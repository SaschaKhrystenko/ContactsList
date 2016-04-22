package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.List;


public interface ContactDAOStorageXML {
    public void marshaller(List<Contact> obj, String nameXmlFile)throws IOException, ClassNotFoundException;
    public void saveToFile(String xml, String nameFile) throws IOException;
    public List<Contact> unmarshalling(File file)throws IOException, ClassNotFoundException;
    public  void marshallerAfterContactRemove(List<Contact> contactList, String nameXmlFie) throws IOException;


}
