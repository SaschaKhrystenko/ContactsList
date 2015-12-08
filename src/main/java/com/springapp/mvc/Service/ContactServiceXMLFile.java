package com.springapp.mvc.Service;

import com.springapp.mvc.Model.Contact;

import java.io.IOException;
import java.util.List;

/**
 * Created by ua001022 on 03.12.2015.
 */
public interface ContactServiceXMLFile {

    public void addContact(Contact contact) throws IOException, ClassNotFoundException;

    public List<Contact> listContact() throws IOException, ClassNotFoundException;

    public void removeContact(Integer id);
}
