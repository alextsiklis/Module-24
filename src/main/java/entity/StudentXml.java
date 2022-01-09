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

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentXml {
    @XmlElement(name = "student")
    private List<Student> students;
}
