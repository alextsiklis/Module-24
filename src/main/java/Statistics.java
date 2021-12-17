import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
