package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@XmlRootElement(name = "student")
public class Student {
    @JsonProperty("fullName")
    @XmlElement(name = "fullName")
    public String fullName;
    @JsonProperty("university-ID")
    @XmlElement(name = "university-ID")
    public String universityId;
    @JsonProperty("course")
    @XmlElement(name = "course")
    public int currentCourseNumber;
    @JsonProperty("score")
    @XmlElement(name = "score")
    public float avgExamScore;

    public static class CompareByName implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return StringUtils.compare(a.getFullName(), b.getFullName());
        }
    }

    public static class CompareByUniId implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return StringUtils.compare(a.getUniversityId(), b.getUniversityId());
        }
    }

    public static class CompareByCourse implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return Integer.compare(a.getCurrentCourseNumber(), b.getCurrentCourseNumber());
        }
    }

    public static class CompareByScore implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return - Float.compare(a.getAvgExamScore(), b.getAvgExamScore());
        }
    }

}