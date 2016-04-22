package com.springapp.mvc.Service;

import com.springapp.mvc.Model.Contact;

import java.io.IOException;
import java.util.List;


public interface ContactServiceXMLFile {

    public void addContact(Contact contact) throws IOException, ClassNotFoundException;

    public List<Contact> listContact() throws IOException, ClassNotFoundException;

    public void removeContact(Long id) throws IOException, ClassNotFoundException;
}
