package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Contact;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.extended.EncodedByteArrayConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua001022 on 03.12.2015.
 */
public class ContactDAOStorageXMLImp implements ContactDAOStorageXML {
    @Override
    public void marshaller(List<Contact> newObj, String nameXmlFile) throws IOException, ClassNotFoundException{
        XStream xStream = new XStream(new DomDriver());
        List<Contact>currentContactList = unmarshalling(new File("C:\\Java\\"+nameXmlFile+".xml"));
        currentContactList.add(newObj.get(0));
        xStream.alias(nameXmlFile, List.class);
        xStream.processAnnotations(Contact.class);
        String xml = xStream.toXML(currentContactList);
        saveToFile(xml, nameXmlFile);
    }

    @Override
    public void saveToFile(String xml, String nameFile) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Java\\"+nameFile+".xml")));
        bufferedWriter.write(xml);
        bufferedWriter.close();
    }

    @Override
    public List<Contact> unmarshalling(File file) throws IOException, ClassNotFoundException{

        XStream xStream = new XStream();
        xStream.processAnnotations(Contact.class);

        xStream.alias("ContactXML", List.class);
        xStream.alias("Contact", Contact.class);
        xStream.aliasField("ContactId", Contact.class, "id");
        xStream.aliasField("Name", Contact.class, "firstName");
        xStream.aliasField("Surname", Contact.class, "secondName");
        xStream.aliasField("Patronymic", Contact.class, "patronymic");
        xStream.aliasField("MobileNumber",Contact.class, "mobileNumber");
        xStream.aliasField("PhoneNumber", Contact.class, "phoneNumber");
        xStream.aliasField("Address", Contact.class, "address");
        xStream.aliasField("Email", Contact.class, "email");

                xStream.registerConverter((Converter) new EncodedByteArrayConverter());
        return (ArrayList<Contact>) xStream.fromXML(file);
    }
}
