package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ua001022 on 03.12.2015.
 */
public interface ContactDAOStorageXML {
    public void marshaller(List<Contact> obj, String nameXmlFile)throws IOException, ClassNotFoundException;
    public void saveToFile(String xml, String nameFile) throws IOException;
    public List<Contact> unmarshalling(File file)throws IOException, ClassNotFoundException;


}
