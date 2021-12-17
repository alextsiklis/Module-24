import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Date;
import java.util.List;

public class JsonWriter {
    public static void createJson(List<University> universities, List<Student> students, List<Statistics> statistics, String name) throws IOException {
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