import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.util.Comparator;

public class Student {
    public String fullName;
    public String universityId;
    public int currentCourseNumber;
    public float avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public static class CompareByName implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return StringUtils.compare(a.getFullName(), b.getFullName());
        }
    };

    public static class CompareByUniId implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return StringUtils.compare(a.getUniversityId(), b.getUniversityId());
        }
    };

    public static class CompareByCourse implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return Integer.compare(a.getCurrentCourseNumber(), b.getCurrentCourseNumber());
        }
    };

    public static class CompareByScore implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return - Float.compare(a.getAvgExamScore(), b.getAvgExamScore());
        }
    };

    @Override
    public String toString() {
        return "Student [fullName=" + fullName +
                ", universityID=" + universityId +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore + "]";
    }
}

