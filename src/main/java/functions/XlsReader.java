package functions;

import entity.Student;
import entity.StudyProfile;
import entity.University;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsReader {
    public static XSSFWorkbook openTable(String file) {
        FileInputStream ExcelFile = null;
        {
            try {
                ExcelFile = new FileInputStream(file);
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
        return workbook;
    }

    public static List readUni(XSSFWorkbook workbook) {
        XSSFSheet sheetUni = workbook.getSheet("Университеты");
        List<University> universities = new ArrayList<>();
        for (int j = 1; j < sheetUni.getLastRowNum(); j++) {
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
        return universities;
    }

    public static List readStu(XSSFWorkbook workbook) {
        XSSFSheet sheetStu = workbook.getSheet("Студенты");
        List<Student> students = new ArrayList<>();
        for (int j = 1; j < sheetStu.getLastRowNum(); j++) {
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
        return students;
    }

    public static void close(String file) throws FileNotFoundException {
        FileInputStream ExcelFile = new FileInputStream(file);
        try {
            ExcelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
