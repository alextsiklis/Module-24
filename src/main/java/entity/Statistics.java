package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @JsonProperty("studyProfile")
    @XmlElement(name = "studyProfile")
    public StudyProfile studyProfile;

    @JsonProperty("AvgExamScore")
    @XmlElement(name = "AvgExamScore")
    public float AvgExamScore;

    @JsonProperty("universityName")
    @XmlElement(name = "universityName")
    public String universityName;

    @JsonProperty("stuCount")
    @XmlElement(name = "stuCount")
    public int stuCount;

}
