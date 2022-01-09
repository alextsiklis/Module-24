package entity;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@XmlRootElement(name = "universities")
@XmlAccessorType(XmlAccessType.FIELD)
public class UniversityXml {
    @XmlElement(name = "university")
    private List<University> universities;
}
