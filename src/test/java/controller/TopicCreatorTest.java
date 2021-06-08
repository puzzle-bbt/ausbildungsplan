package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TopicCreatorTest {
    //TODO: Revise tests

    private TopicCreator topicCreator;

    HashMap<String, ArrayList> mapYamlObjects = new HashMap<>();

    ArrayList<TopicYaml> yamlAllTopics = new ArrayList<>();
    ArrayList<CompetencyYaml> yamlAllCompetencies = new ArrayList<>();
    ArrayList<CompetencyLevelYaml> yamlAllCompetencyLevels = new ArrayList<>();

    private ArrayList<TopicYaml> setUpAllYamlTopics() {
        TopicYaml topicYaml1 = new TopicYaml("1", "Topic1", "First topic");

        TopicYaml topicYaml2 = new TopicYaml("2", "Topic2", "Second topic");

        yamlAllTopics.add(topicYaml1);
        yamlAllTopics.add(topicYaml2);

        return yamlAllTopics;
    }

    private ArrayList<CompetencyYaml> setUpAllCompetencies() {
        CompetencyYaml competencyYaml11 = new CompetencyYaml("1.1", "Competency11", "First competency first topic");
        //topic_id ="1"

        CompetencyYaml competencyYaml12 = new CompetencyYaml("1.2", "Competency12", "Second competency first topic");
        //topic_id ="1"


        CompetencyYaml competencyYaml21 = new CompetencyYaml("2.1", "Competency21", "First competency second topic");
        //topic_id ="2"

        yamlAllCompetencies.add(competencyYaml11);
        yamlAllCompetencies.add(competencyYaml12);
        yamlAllCompetencies.add(competencyYaml21);
        return yamlAllCompetencies;
    }

    private ArrayList<CompetencyLevelYaml> setUpAllCompetencyLevels() {
        CompetencyLevelYaml competencyLevelYaml111 = new CompetencyLevelYaml("1.1.1", new ArrayList<>(), new ArrayList<>());
        //competency_id="1.1"


        CompetencyLevelYaml competencyLevelYaml112 = new CompetencyLevelYaml("1.1.2", new ArrayList<>(), new ArrayList<>());
        //competency_id="1.1"


        CompetencyLevelYaml competencyLevelYaml121 = new CompetencyLevelYaml("1.2.1", new ArrayList<>(), new ArrayList<>());
        //competency_id="1.2"


        CompetencyLevelYaml competencyLevelYaml211 = new CompetencyLevelYaml("2.1.1", new ArrayList<>(), new ArrayList<>());
        //competency_id="2.1"

        yamlAllCompetencyLevels.add(competencyLevelYaml111);
        yamlAllCompetencyLevels.add(competencyLevelYaml112);
        yamlAllCompetencyLevels.add(competencyLevelYaml121);
        yamlAllCompetencyLevels.add(competencyLevelYaml211);

        return yamlAllCompetencyLevels;
    }


    @Before
    public void setUpYamlObjects() {
        topicCreator = new TopicCreator();
        setUpAllYamlTopics();
        setUpAllCompetencies();
        setUpAllCompetencyLevels();

        mapYamlObjects.put("topics", yamlAllTopics);
        mapYamlObjects.put("competencies", yamlAllCompetencies);
        mapYamlObjects.put("levels", yamlAllCompetencyLevels);

    }


    @Test
    public void returnEmptyTopicListForEmptyListsInHashMap() {
        //given
        HashMap<String, ArrayList> mapYamlObjects = new HashMap<>();
        mapYamlObjects.put("topics", new ArrayList());
        mapYamlObjects.put("competencies", new ArrayList());
        mapYamlObjects.put("levels", new ArrayList());

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        assertTrue(resultTopic.isEmpty());

    }

    @Test
    public void returnTopicWtihEmptyCompetencies() {
        //given
        HashMap<String, ArrayList> mapYamlObjects = new HashMap<>();

        mapYamlObjects.put("topics", yamlAllTopics);
        mapYamlObjects.put("competencies", new ArrayList());
        mapYamlObjects.put("levels", new ArrayList());

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        assertFalse(resultTopic.isEmpty());
        for (Topic topic : resultTopic) {
            assertTrue(topic.getCompentencies().isEmpty());
        }
    }

    @Test
    public void returnTopicWtihCompetenciesWithEmptyLevels() {
        //given
        HashMap<String, ArrayList> mapYamlObjects = new HashMap<>();

        mapYamlObjects.put("topics", yamlAllTopics);
        mapYamlObjects.put("competencies", yamlAllCompetencies);
        mapYamlObjects.put("levels", new ArrayList());

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        assertFalse(resultTopic.isEmpty());
        for (Topic topic : resultTopic) {
            assertFalse(topic.getCompentencies().isEmpty());
            for (Competency competency : topic.getCompentencies()) {
                assertTrue(competency.getCompetencyLevels().isEmpty());
            }
        }
    }

    @Test
    public void returnTopicWtihCompetenciesWithLevels() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        assertFalse(resultTopic.isEmpty());
        for (Topic topic : resultTopic) {
            assertFalse(topic.getCompentencies().isEmpty());
            for (Competency competency : topic.getCompentencies()) {
                assertFalse(competency.getCompetencyLevels().isEmpty());
            }
        }
    }

    @Test
    public void returnRightSizeTopics() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        assertEquals(2, resultTopic.size());
    }

    @Test
    public void returnRightTopics() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        assertEquals("1", resultTopic.get(0).getId());
        assertEquals("2", resultTopic.get(1).getId());
    }

    @Test
    public void returnRightSizeCompetenciesForTopics() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        ArrayList<Competency> resultCompetencies1 = getCompetenciesByTopicId(resultTopic, "1");
        ArrayList<Competency> resultCompetencies2 = getCompetenciesByTopicId(resultTopic, "2");

        assertEquals(2, resultCompetencies1.size());
        assertEquals(1, resultCompetencies2.size());
    }

    @Test
    public void returnRightCompetenciesForTopics() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        ArrayList<Competency> resultCompetencies1 = getCompetenciesByTopicId(resultTopic, "1");
        ArrayList<Competency> resultCompetencies2 = getCompetenciesByTopicId(resultTopic, "2");

        assertEquals("1.1", resultCompetencies1.get(0).getId());
        assertEquals("1.2", resultCompetencies1.get(1).getId());

        assertEquals("2.1", resultCompetencies2.get(0).getId());
    }


    @Test
    public void returnRightSizeCompetencyLevelsForCompetencies() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        ArrayList<CompetencyLevel> resultCompetencyLevels11 = getCompetencyLevelsByCompetencyId(resultTopic, "1.1");
        ArrayList<CompetencyLevel> resultCompetencyLevels12 = getCompetencyLevelsByCompetencyId(resultTopic, "1.2");
        ArrayList<CompetencyLevel> resultCompetencyLevels21 = getCompetencyLevelsByCompetencyId(resultTopic, "2.1");

        assertEquals(2, resultCompetencyLevels11.size());
        assertEquals(1, resultCompetencyLevels12.size());
        assertEquals(1, resultCompetencyLevels21.size());
    }

    @Test
    public void returnRightCompetencyLevelsForCompetencies() {
        //given: setUpYamlObjects

        //when
        ArrayList<Topic> resultTopic = topicCreator.createTopics(mapYamlObjects);

        //then
        ArrayList<CompetencyLevel> resultCompetencyLevels11 = getCompetencyLevelsByCompetencyId(resultTopic, "1.1");
        ArrayList<CompetencyLevel> resultCompetencyLevels12 = getCompetencyLevelsByCompetencyId(resultTopic, "1.2");
        ArrayList<CompetencyLevel> resultCompetencyLevels21 = getCompetencyLevelsByCompetencyId(resultTopic, "2.1");

        assertEquals("1.1.1", resultCompetencyLevels11.get(0).getId());
        assertEquals("1.1.2", resultCompetencyLevels11.get(1).getId());

        assertEquals("1.2.1", resultCompetencyLevels12.get(0).getId());

        assertEquals("2.1.1", resultCompetencyLevels21.get(0).getId());
    }

    /**
     * Helper methods
     */

    public ArrayList<Competency> getCompetenciesByTopicId(ArrayList<Topic> topics, String id) {
        ArrayList<Competency> compentencies = new ArrayList<>();
        for (Topic topic : topics) {
            for (Competency competency : topic.getCompentencies()) {
                if (competency.getId().startsWith(id)) {
                    compentencies.add(competency);
                }
            }
        }
        return compentencies;
    }

    public ArrayList<CompetencyLevel> getCompetencyLevelsByCompetencyId(ArrayList<Topic> topics, String id) {
        ArrayList<CompetencyLevel> levels = new ArrayList<>();
        for (Topic topic : topics) {
            for (Competency competency : topic.getCompentencies()) {
                for (CompetencyLevel level : competency.getCompetencyLevels()) {
                    if (level.getId().startsWith(id)) {
                        levels.add(level);
                    }
                }
            }
        }
        return levels;
    }


}