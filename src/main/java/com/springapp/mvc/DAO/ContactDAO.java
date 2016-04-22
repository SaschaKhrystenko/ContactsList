package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Contact;

import java.util.List;


public interface ContactDAO {

    public void addContact(Contact contact,Long id);

    public List<Contact> contactListByAccountId(Long accountId);

    public void removeContact(Long contactId);

    public Contact getContactById(Long contactId);

    public void editContact (Contact contact, Long contactId, Long accountId);
}
