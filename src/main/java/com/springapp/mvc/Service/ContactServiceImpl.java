package com.springapp.mvc.Service;

import com.springapp.mvc.DAO.ContactDAO;
import com.springapp.mvc.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    @Override
    public void addContact(Contact contact, Long id) {
        contactDAO.addContact(contact, id);

    }
    @Transactional
    @Override
    public List<Contact> contactListByAccountId(Long accountID) {
        return contactDAO.contactListByAccountId(accountID);
    }

    @Transactional
    @Override
    public void removeContact(Long contactID) {
        contactDAO.removeContact(contactID);

    }

    @Transactional
    @Override
    public Contact getContactById(Long contactId) {
        return contactDAO.getContactById(contactId);
    }

    @Transactional
    @Override
    public void editContact(Contact contact, Long contactId, Long accountId) {
       contactDAO.editContact(contact,contactId,accountId);
    }
}
