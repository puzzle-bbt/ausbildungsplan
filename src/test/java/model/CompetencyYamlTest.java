package model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CompetencyYamlTest {

    @Test
    public void checkTopicIdOfCompetency1() {
        //when
        CompetencyYaml competencyYaml = new CompetencyYaml("1.2", "CompTitle", "CompDescription");

        //then
        assertEquals("1", competencyYaml.getTopic_id());
    }

    @Test
    public void checkTopicIdOfCompetency2() {
        //when
        CompetencyYaml competencyYaml = new CompetencyYaml("2.2", "CompTitle", "CompDescription");

        //then
        assertEquals("2", competencyYaml.getTopic_id());
    }

    @Test
    public void checkTopicIdOfCompetency3() {
        //when
        CompetencyYaml competencyYaml = new CompetencyYaml("123456.789123456", "CompTitle", "CompDescription");

        //then
        assertEquals("123456", competencyYaml.getTopic_id());
    }


}