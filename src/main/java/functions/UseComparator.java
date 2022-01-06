package functions;

import entity.EnumStudent;
import entity.EnumUniversity;
import entity.Student;
import entity.University;

import java.util.Comparator;

public class UseComparator {

    private UseComparator() {
    }

    public static Comparator<Student> getStudentComparator(EnumStudent enumStudent) {
        if (enumStudent == EnumStudent.NAME) {
            Student.CompareByName compareByName = new Student.CompareByName();
            return compareByName;
        }
        if (enumStudent == EnumStudent.UNIID) {
            Student.CompareByUniId compareByUniId = new Student.CompareByUniId();
            return compareByUniId;
        }
        if (enumStudent == EnumStudent.COURSE) return new Student.CompareByCourse();
        if (enumStudent == EnumStudent.SCORE) return new Student.CompareByScore();
        else return null;
    }

    public static Comparator<University> getUniversityComparator(EnumUniversity enumUniversity) {
        if (enumUniversity == EnumUniversity.NAME) {
            University.CompareByName compareByName = new University.CompareByName();
            return compareByName;
        }
        if (enumUniversity == EnumUniversity.ID) {
            University.CompareById compareById = new University.CompareById();
            return compareById;
        }
        if (enumUniversity == EnumUniversity.YEAR) {
            University.CompareByYear compareByYear = new University.CompareByYear();
            return compareByYear;
        }
        else return null;
    }

}
