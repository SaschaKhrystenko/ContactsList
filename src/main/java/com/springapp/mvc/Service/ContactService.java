package com.springapp.mvc.Service;

import com.springapp.mvc.Model.Contact;

import java.util.List;

/**
 * Created by ua001022 on 27.11.2015.
 */
public interface ContactService {
    public void addContact(Contact contact, Long id);

    public List<Contact> contactListByAccountId(Long accountId);

    public void removeContact(Long contactId);

    public void editContact (Long contactId);

}
