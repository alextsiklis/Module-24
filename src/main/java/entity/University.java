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

@XmlRootElement(name = "university")
public class University {
    @JsonProperty("ID")
    @XmlElement(name = "ID")
    private String id;

    @JsonProperty("fullName")
    @XmlElement(name = "fullName")
    private String fullName;

    @JsonProperty("shortName")
    @XmlElement(name = "shortName")
    private String shortName;

    @JsonProperty("yearOfFoundation")
    @XmlElement(name = "yearOfFoundation")
    private int yearOfFoundation;

    @JsonProperty("mainProfile")
    @XmlElement(name = "mainProfile")
    private StudyProfile mainProfile;

    public static class CompareByName implements Comparator<University> {
        @Override
        public int compare(University a, University b) {
            return StringUtils.compare(a.getFullName(), b.getFullName());
        }
    }

    public static class CompareById implements Comparator<University> {
        @Override
        public int compare(University a, University b) {
            return StringUtils.compare(a.getId(), b.getId());
        }
    }

    public static class CompareByYear implements Comparator<University> {
        @Override
        public int compare(University a, University b) {
            return Integer.compare(a.getYearOfFoundation(), b.getYearOfFoundation());
        }
    }
}