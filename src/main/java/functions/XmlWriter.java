package functions;

import entity.Student;
import entity.University;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

public class XmlWriter {
    public static void createXml(List<University> universities, List<Student> students, String name) throws JAXBException {
        Date date = new Date();
        String filename = String.format("%s_%tF.xls", name, date);
        File file = new File(String.format("XMLFiles/%s", filename));

        for (University university : universities) {
            JAXBContext jaxbContextUni = JAXBContext.newInstance(University.class);
            Marshaller jaxbMarshallerUni = jaxbContextUni.createMarshaller();
            jaxbMarshallerUni.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshallerUni.marshal(university, file);
        }

        for (Student student : students) {
            JAXBContext jaxbContextStu = JAXBContext.newInstance(Student.class);
            Marshaller jaxbMarshallerStu = jaxbContextStu.createMarshaller();
            jaxbMarshallerStu.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshallerStu.marshal(student, file);
        }
    }
}
