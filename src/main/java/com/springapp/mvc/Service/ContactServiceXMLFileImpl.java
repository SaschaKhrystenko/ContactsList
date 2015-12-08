package com.springapp.mvc.Service;

import com.springapp.mvc.DAO.ContactDAOStorageXML;
import com.springapp.mvc.DAO.ContactDAOStorageXMLImp;
import com.springapp.mvc.Model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua001022 on 03.12.2015.
 */
public class ContactServiceXMLFileImpl implements ContactServiceXMLFile {

    ContactDAOStorageXML contactDAOStorageXML = new ContactDAOStorageXMLImp();

    @Override
    public void addContact(Contact contact) throws IOException, ClassNotFoundException {
        List<Contact>contactList = new ArrayList<Contact>();
        contactList.add(contact);
        contactDAOStorageXML.marshaller(contactList,"ContactXML" );
    }

    @Override
    public List<Contact> listContact() throws IOException, ClassNotFoundException {

        List<Contact> contacts = contactDAOStorageXML.unmarshalling(new File("ContactXML"));

        return contacts;
    }

    @Override
    public void removeContact(Integer id) {

    }
}
