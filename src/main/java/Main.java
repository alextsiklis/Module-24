import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        FileInputStream ExcelFile = null;
        {
            try {
                ExcelFile = new FileInputStream("src/main/resources/universityInfo.xlsx");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        XSSFWorkbook workbook = null;
        {
            try {
                workbook = new XSSFWorkbook(ExcelFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<University> universities = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        XSSFSheet sheetUni = workbook.getSheet("Университеты");

        for (int j = 1; j < sheetUni.getLastRowNum(); j++){
            XSSFRow row = sheetUni.getRow(j);
            University university = new University();
            for (int i = 0; i < sheetUni.getRow(0).getLastCellNum(); i++) {
                XSSFCell cell = row.getCell(i);
                if (i == 0) {
                    university.setId(cell.getRichStringCellValue().getString());
                }
                if (i == 1) {
                    university.setFullName(cell.getRichStringCellValue().getString());
                }
                if (i == 2) {
                    university.setShortName(cell.getRichStringCellValue().getString());
                }
                if (i == 3) {
                    university.setYearOfFoundation((int) cell.getNumericCellValue());
                }
                if (i == 4) {
                    university.setMainProfile(StudyProfile.valueOf(cell.getRichStringCellValue().getString()));
                }
            }
            universities.add(university);
        }

        XSSFSheet sheetStu = workbook.getSheet("Студенты");

        for (int j = 1; j < sheetStu.getLastRowNum(); j++){
            XSSFRow row = sheetStu.getRow(j);
            Student student = new Student();
            for (int i = 0; i < sheetStu.getRow(0).getLastCellNum(); i++) {
                XSSFCell cell = row.getCell(i);
                if (i == 0) {
                    student.setUniversityId(cell.getRichStringCellValue().getString());
                }
                if (i == 1) {
                    student.setFullName(cell.getRichStringCellValue().getString());
                }
                if (i == 2) {
                    student.setCurrentCourseNumber((int) cell.getNumericCellValue());
                }
                if (i == 3) {
                    student.setAvgExamScore((float) cell.getNumericCellValue());
                }
            }
            students.add(student);
        }

        try {
            ExcelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<Student> studentComparator = UseComparator.getStudentComparator(EnumStudent.NAME);
        Comparator<University> universityComparator = UseComparator.getUniversityComparator(EnumUniversity.NAME);

        universities.sort(universityComparator);
        students.sort(studentComparator);

        Stream streamUni = universities.stream();
        Stream streamStu = students.stream();

        streamUni.forEach(System.out::println);
        streamStu.forEach(System.out::println);

//        for (University university : universities) {
//            System.out.println(university.toString());
//        }
//
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }
    }
}