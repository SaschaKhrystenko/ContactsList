package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Account;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ua001022 on 06.12.2015.
 */
@Repository
public class RegisterDAOImpl implements RegisterDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void register(Account account) {

             sessionFactory.getCurrentSession().save(account);
    }

    @Override
    public boolean isUnique(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Account where login = :currentLogin");
        query.setParameter("currentLogin", login).uniqueResult();
        List<Account> accountList = query.list();
        if(accountList.size()>0) return false;

        return true;
    }
}
