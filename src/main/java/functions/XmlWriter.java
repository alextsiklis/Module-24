package functions;

import entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;
import java.util.List;

public class XmlWriter {
    public static void createXml(StatXml stat, UniversityXml university, StudentXml student, String name) throws JAXBException {
        Date date = new Date();
        String filename = String.format("%s_%tF.xml", name, date);
        File file = new File(String.format("XMLFiles/%s", filename));
        File fileUni = new File("XMLFiles/universities.xml");
        File fileStu = new File("XMLFiles/students.xml");

        JAXBContext jaxbContextUni = JAXBContext.newInstance(UniversityXml.class);
        Marshaller jaxbMarshallerUni = jaxbContextUni.createMarshaller();
        jaxbMarshallerUni.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshallerUni.marshal(university, fileUni);

        JAXBContext jaxbContextStu = JAXBContext.newInstance(StudentXml.class);
        Marshaller jaxbMarshallerStu = jaxbContextStu.createMarshaller();
        jaxbMarshallerStu.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshallerStu.marshal(student, fileStu);

        JAXBContext jaxbContextStat = JAXBContext.newInstance(StatXml.class);
        Marshaller jaxbMarshallerStat = jaxbContextStat.createMarshaller();
        jaxbMarshallerStat.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshallerStat.marshal(stat, file);
    }
}
