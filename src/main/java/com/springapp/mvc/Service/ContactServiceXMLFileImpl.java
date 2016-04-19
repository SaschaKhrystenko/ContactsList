package com.springapp.mvc.Service;

import com.springapp.mvc.DAO.ContactDAOStorageXML;
import com.springapp.mvc.DAO.ContactDAOStorageXMLImp;
import com.springapp.mvc.Model.Account;
import com.springapp.mvc.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContactServiceXMLFileImpl implements ContactServiceXMLFile {

   @Autowired
   private ContactDAOStorageXML contactDAOStorageXML;

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
    public void removeContact(Long id)  throws IOException, ClassNotFoundException {
        List<Contact>currentCustomerList = contactDAOStorageXML.unmarshalling(new File("C:\\Java\\ContactXML.xml"));

        for(Contact contact: currentCustomerList){
            if(contact.getId()==id){
                currentCustomerList.remove(contact);
            }
        }

        contactDAOStorageXML.marshallerAfterContactRemove(currentCustomerList, "ContactXML");


    }
}
