package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.CompetencyLevelYaml;
import model.CompetencyYaml;
import model.Semester;
import model.TopicYaml;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SourceDataReaderTest {

    private SourceDataReader reader;

    @Mock
    ObjectMapper mapper;
    private static final String FILE_PATH_YAMLS_TO_PROCESS = "src/test/resources/data1b";
    private static final String FILE_PATH_YAMLS_TO_PROCESS_EXCEPTION = "src/test/resources/dataException";


    @Before
    public void setUp() {
        reader = new SourceDataReader(mapper);
    }

    @Test
    public void verifyReadAllSourceDataIsCalledForEachFolder() throws Exception {
        //given
        SourceDataReader reader = Mockito.spy(new SourceDataReader());

        ArrayList<File> folderPathList = new ArrayList<>();
        folderPathList.add(new File(FILE_PATH_YAMLS_TO_PROCESS));
        folderPathList.add(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1"));
        folderPathList.add(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1"));
        folderPathList.add(new File(FILE_PATH_YAMLS_TO_PROCESS + "/conf"));

        //when
        reader.readAllSourceData(new File(FILE_PATH_YAMLS_TO_PROCESS));

        //then
        for (File file : folderPathList) {
            Mockito.verify(reader, times(1)).readAllSourceData(file);
        }
    }

    @Test
    public void verifyMapperDoesReadEachFile() throws Exception {
        //when
        reader.readAllSourceData(new File(FILE_PATH_YAMLS_TO_PROCESS));

        //then
        Mockito.verify(mapper, times(1)).readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/topic.yaml"), TopicYaml.class);
        Mockito.verify(mapper, times(1)).readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/competency.yaml"), CompetencyYaml.class);
        Mockito.verify(mapper, times(1)).readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/level1.yaml"), CompetencyLevelYaml.class);
        Mockito.verify(mapper, times(1)).readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/conf/semester.yaml"), Semester.class);

    }

    @Test
    public void readAllSourceDataTestThrowsException() {
        //when
        String expectedMessage = "Unknown yaml file: unknownFileName.yaml";
        String actualMessage = "";
        try {
            reader.readAllSourceData(new File(FILE_PATH_YAMLS_TO_PROCESS_EXCEPTION));
        } catch (Exception e) {
            actualMessage = e.getMessage();
        }
        //then
        assertEquals(actualMessage, expectedMessage);
    }


    @Test
    public void readAndPrepareAllSourceReturnsRightSizedHashMap() throws Exception {
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/topic.yaml"), TopicYaml.class)).thenReturn(new TopicYaml("1", "TopicTitle", "TopicDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/competency.yaml"), CompetencyYaml.class)).thenReturn(new CompetencyYaml("1.2", "CompTitle", "CompDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/level1.yaml"), CompetencyLevelYaml.class)).thenReturn(new CompetencyLevelYaml("1.2.3", new ArrayList<>(), new ArrayList<>()));

        HashMap<String, ArrayList> resultMapYamlObjects = reader.readAndPrepareAllSourceDataYamls(FILE_PATH_YAMLS_TO_PROCESS);

        assertEquals(3, resultMapYamlObjects.size());
    }

    @Test
    public void readAndPrepareAllSourceReturnsMapWithRightKeys() throws Exception {
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/topic.yaml"), TopicYaml.class)).thenReturn(new TopicYaml("1", "TopicTitle", "TopicDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/competency.yaml"), CompetencyYaml.class)).thenReturn(new CompetencyYaml("1.2", "CompTitle", "CompDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/level1.yaml"), CompetencyLevelYaml.class)).thenReturn(new CompetencyLevelYaml("1.2.3", new ArrayList<>(), new ArrayList<>()));

        HashMap<String, ArrayList> resultMapYamlObjects = reader.readAndPrepareAllSourceDataYamls(FILE_PATH_YAMLS_TO_PROCESS);

        assertTrue(resultMapYamlObjects.containsKey("topics"));
        assertTrue(resultMapYamlObjects.containsKey("competencies"));
        assertTrue(resultMapYamlObjects.containsKey("levels"));
    }

    @Test
    public void readAndPrepareAllSourceReturnsMapWithRightSizedArrays() throws Exception {
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/topic.yaml"), TopicYaml.class)).thenReturn(new TopicYaml("1", "TopicTitle", "TopicDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/competency.yaml"), CompetencyYaml.class)).thenReturn(new CompetencyYaml("1.2", "CompTitle", "CompDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/level1.yaml"), CompetencyLevelYaml.class)).thenReturn(new CompetencyLevelYaml("1.2.3", new ArrayList<>(), new ArrayList<>()));

        HashMap<String, ArrayList> resultMapYamlObjects = reader.readAndPrepareAllSourceDataYamls(FILE_PATH_YAMLS_TO_PROCESS);

        assertEquals(1, resultMapYamlObjects.get("topics").size());
        assertEquals(1, resultMapYamlObjects.get("competencies").size());
        assertEquals(1, resultMapYamlObjects.get("levels").size());

    }

    @Test
    public void readAndPrepareAllSourceReturnsMapWithRightTypedArrays() throws Exception {
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/topic.yaml"), TopicYaml.class)).thenReturn(new TopicYaml("1", "TopicTitle", "TopicDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/competency.yaml"), CompetencyYaml.class)).thenReturn(new CompetencyYaml("1.2", "CompTitle", "CompDescription"));
        when(mapper.readValue(new File(FILE_PATH_YAMLS_TO_PROCESS + "/topic1/competency1/level1.yaml"), CompetencyLevelYaml.class)).thenReturn(new CompetencyLevelYaml("1.2.3", new ArrayList<>(), new ArrayList<>()));

        HashMap<String, ArrayList> resultMapYamlObjects = reader.readAndPrepareAllSourceDataYamls(FILE_PATH_YAMLS_TO_PROCESS);

        assertEquals(TopicYaml.class, resultMapYamlObjects.get("topics").get(0).getClass());
        assertEquals(CompetencyYaml.class, resultMapYamlObjects.get("competencies").get(0).getClass());
        assertEquals(CompetencyLevelYaml.class, resultMapYamlObjects.get("levels").get(0).getClass());

    }

    @Test
    public void readAndPrepareAllSourceDataYamlsThrowsException() {
        String expectedMessage = "Unknown yaml file: unknownFileName.yaml";
        String actualMessage = "";
        try {
            reader.readAndPrepareAllSourceDataYamls(FILE_PATH_YAMLS_TO_PROCESS_EXCEPTION);
        } catch (Exception e) {
            actualMessage = e.getMessage();
        }
        assertEquals(actualMessage, expectedMessage);
    }


}