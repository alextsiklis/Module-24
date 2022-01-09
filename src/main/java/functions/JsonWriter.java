package functions;

import entityJson.StatJson;
import entityJson.StudentJson;
import entityJson.UniversityJson;

import java.io.*;
import java.util.Date;
import com.google.gson.GsonBuilder;

public class JsonWriter {
    public static void createJson(UniversityJson universities, StudentJson students, StatJson statistics, String name) {
        Date date = new Date();
        String filename = String.format("%s_%tF.json", name, date);

        String resultStu = new GsonBuilder().setPrettyPrinting().create().toJson(students);
        String resultUni = new GsonBuilder().setPrettyPrinting().create().toJson(universities);
        String resultStat = new GsonBuilder().setPrettyPrinting().create().toJson(statistics);

        try (FileWriter fileUni = new FileWriter("JSONFiles/universities.json")) {
            fileUni.write(resultUni);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileStu = new FileWriter("JSONFiles/students.json")) {
            fileStu.write(resultStu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(String.format("JSONFiles/%s", filename))) {
            file.write(resultStat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}