import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class XmlWriter {
    public static void createXml(List<University> universities, List<Student> students, String name) throws JAXBException {
        Date date = new Date();
        String filename = String.format("%s_%tF.xls", name, date);
        File file = new File(String.format("XMLFiles/%s", filename));
//        try {
//            XmlMapper xmlMapper = new XmlMapper();
//            String xmlStringUni = xmlMapper.writeValueAsString(universities);
//            String xmlStringStu = xmlMapper.writeValueAsString(students);
//            File xmlOutput = new File(String.format("XMLFiles/%s", filename));
//            FileWriter fileWriter = new FileWriter(xmlOutput);
//            fileWriter.write(xmlStringUni + "\n" + xmlStringStu);
//            fileWriter.close();
//        } catch (IOException e) {
//        }
//    }

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
