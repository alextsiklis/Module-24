import org.apache.poi.xwpf.usermodel.XWPFLatentStyles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = "src/main/resources/universityInfo.xlsx";

        PackageCreator.createPackage("XLSFiles");
        PackageCreator.createPackage("JSONFiles");
        PackageCreator.createPackage("XMLFiles");

        List<University> universities = XlsReader.readUni(XlsReader.openTable(file));
        List<Student> students = XlsReader.readStu(XlsReader.openTable(file));

//        for (University university : universities) {
//            System.out.println(university.toString());
//        }
//
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }

//        Comparator<Student> studentComparator = UseComparator.getStudentComparator(EnumStudent.NAME);
//        Comparator<University> universityComparator = UseComparator.getUniversityComparator(EnumUniversity.NAME);

//        universities.sort(universityComparator);
//        students.sort(studentComparator);
//
//        Stream streamUni = universities.stream();
//        Stream streamStu = students.stream();
//
//        streamUni.forEach(System.out::println);
//        streamStu.forEach(System.out::println);

        List<Statistics> statistics = Transformer.former(students, universities);
        try {
            XlsWriter.createTable(statistics, "statistics");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JsonWriter.createJson(universities, students, statistics, "statistics");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XlsReader.close(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}