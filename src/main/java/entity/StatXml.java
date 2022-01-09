package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@XmlRootElement(name = "statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatXml {
    @XmlElement(name = "statistics")
    private List<Statistics> statistics;
}
