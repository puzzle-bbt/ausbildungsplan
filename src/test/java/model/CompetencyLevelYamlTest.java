package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CompetencyLevelYamlTest {

    private ArrayList<String> instruments;
    private ArrayList<String> goals;

    @Before
    public void setUp() {
        instruments = new ArrayList<>();
        instruments.add("instrument1");
        instruments.add("instrument2");


        goals = new ArrayList<>();
        goals.add("goals1");
        goals.add("goals2");
    }

    @Test
    public void checkCompetencyIdOfCompetencyLevel1() {
        //when
        CompetencyLevelYaml competencyLevelYaml = new CompetencyLevelYaml("1.2.3", instruments, goals);

        //then
        assertEquals("1.2", competencyLevelYaml.getCompetency_id());
    }

    @Test
    public void checkCompetencyIdOfCompetencyLevel2() {
        //when
        CompetencyLevelYaml competencyLevelYaml = new CompetencyLevelYaml("10.11.12", instruments, goals);

        //then
        assertEquals("10.11", competencyLevelYaml.getCompetency_id());
    }

    @Test
    public void checkCompetencyIdOfCompetencyLevel3() {
        //when
        CompetencyLevelYaml competencyLevelYaml = new CompetencyLevelYaml("12345.6789123.4567891234", instruments, goals);

        //then
        assertEquals("12345.6789123", competencyLevelYaml.getCompetency_id());
    }


}