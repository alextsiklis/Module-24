package functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Statistics;
import entity.Student;
import entity.University;

import java.io.*;
import java.util.Date;
import java.util.List;

public class JsonWriter {
    public static void createJson(List<University> universities, List<Student> students, List<Statistics> statistics, String name) throws JsonProcessingException {
        Date date = new Date();
        String filename = String.format("%s_%tF.json", name, date);

        ObjectMapper mapper = new ObjectMapper();

        String result1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        String result2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(universities);
        String result3 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(statistics);
        String result = result1 + "\n" + result2 + "\n" + result3;

        try (FileWriter file = new FileWriter(String.format("JSONFiles/%s", filename))) {
            file.write(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}