package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Contact;

import java.util.List;

/**
 * Created by ua001022 on 27.11.2015.
 */
public interface ContactDAO {

    public void addContact(Contact contact,Long id);

    public List<Contact> contactListByAccountId(Long accountId);

    public void removeContact(Long contactId);
}
