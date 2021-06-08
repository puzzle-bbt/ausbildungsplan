package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SourceDataReader {
    ObjectMapper mapper;

    ArrayList<TopicYaml> yamlTopics = new ArrayList<>();
    ArrayList<CompetencyYaml> yamlCompetencies = new ArrayList<>();
    ArrayList<CompetencyLevelYaml> yamlCompetencyLevels = new ArrayList<>();
    Semester semester;

    public SourceDataReader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public SourceDataReader() {
        this.mapper = new ObjectMapper(new YAMLFactory());

    }

    public HashMap<String, ArrayList> readAndPrepareAllSourceDataYamls(String filePathYamlsToProcess) throws Exception {

        HashMap<String, ArrayList> mapYamlObjects = new HashMap<>();

        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        readAllSourceData(new File(filePathYamlsToProcess));

        for (CompetencyYaml competency : yamlCompetencies) {
            competency.parseAndSetTopicId();
        }

        for (CompetencyLevelYaml level : yamlCompetencyLevels) {
            level.parseAndSetCompetencyId();
        }

        mapYamlObjects.put("topics", yamlTopics);
        mapYamlObjects.put("competencies", yamlCompetencies);
        mapYamlObjects.put("levels", yamlCompetencyLevels);

        return mapYamlObjects;
    }


    public void readAllSourceData(final File folder) throws Exception {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                readAllSourceData(fileEntry);
            } else {
                if (fileEntry.getName().startsWith("topic")) {
                    yamlTopics.add(mapper.readValue(fileEntry, TopicYaml.class));
                } else if (fileEntry.getName().startsWith("competency")) {
                    yamlCompetencies.add(mapper.readValue(fileEntry, CompetencyYaml.class));
                } else if (fileEntry.getName().startsWith("level")) {
                    yamlCompetencyLevels.add(mapper.readValue(fileEntry, CompetencyLevelYaml.class));
                } else if (fileEntry.getName().startsWith("semester")) {
                    //TODO semester
                    semester = mapper.readValue(fileEntry, Semester.class);
                } else {
                    throw new Exception("Unknown yaml file: " + fileEntry.getName());
                }
            }
        }


    }


    public void createMasterYaml(Plan plan) throws IOException {
        mapper.writeValue(new File("src/main/resources/testMaster.yaml"), plan);
    }
}
