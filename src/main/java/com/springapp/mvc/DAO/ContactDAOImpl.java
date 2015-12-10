package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Account;
import com.springapp.mvc.Model.Contact;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua001022 on 27.11.2015.
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addContact(Contact contact, Long id) {
        Account account = (Account) sessionFactory.getCurrentSession().get(Account.class, new Long(id));
        contact.setAccount(account);
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public List<Contact> contactListByAccountId(Long accountId) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Contact contact WHERE contact.account =:accountId");
        query.setLong("accountId", accountId);
        return (List<Contact>) query.list();
    }

    @Override
    public void removeContact(Long contactId) {


        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, contactId);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);

        }
    }
}
