import entity.*;
import functions.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "src/main/resources/universityInfo.xlsx";

        for (String s : Arrays.asList("XLSFiles", "JSONFiles", "XMLFiles")) {
            PackageCreator.createPackage(s);
        }

        List<University> universities = XlsReader.readUni(XlsReader.openTable(file));
        List<Student> students = XlsReader.readStu(XlsReader.openTable(file));

//        for (entity.University university : universities) {
//            System.out.println(university.toString());
//        }

//        for (entity.Student student : students) {
//            System.out.println(student.toString());
//        }

//        functions.Comparator<entity.Student> studentComparator = functions.UseComparator.getStudentComparator(entity.EnumStudent.NAME);
//        functions.Comparator<entity.University> universityComparator = functions.UseComparator.getUniversityComparator(entity.EnumUniversity.NAME);

//        universities.sort(universityComparator);
//        students.sort(studentComparator);

//        Stream streamUni = universities.stream();
//        Stream streamStu = students.stream();

//        streamUni.forEach(System.out::println);
//        streamStu.forEach(System.out::println);

        List<Statistics> statistics = Transformer.former(students, universities);
//        try {
//            functions.JsonWriter.createJson(universities, students, statistics, "statistics");
//            functions.LogCreator.logCreator("JSON файл создан и заполнен информацией");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        UniversityXml universityXml = new UniversityXml(universities);
        StatXml statXml = new StatXml(statistics);
        StudentXml studentXml = new StudentXml(students);

        try {
            XmlWriter.createXml( statXml, universityXml, studentXml, "statistics");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        LogCreator.logCreator("XML файл создан и заполнен информацией");

        try {
            XlsWriter.createTable(statistics, "statistics");
            LogCreator.logCreator("Xls файл создан и заполнен информацией");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XlsReader.close(file);
            LogCreator.logCreator("Задача выполнена");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}