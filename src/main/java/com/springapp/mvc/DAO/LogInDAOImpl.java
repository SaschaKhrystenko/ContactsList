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
public class LogInDAOImpl implements LogInDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long authenticate(String login, String password) {
        Long result = 0L;
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("select a.id from Account a where a.login=? and a.password=?");
        query.setParameter(0,login);
        query.setParameter(1,password);

        List<Long> idList = query.list();

        if (idList.size() > 0) {
            result = idList.get(0);
            return result;
        }

       return result;
    }
}
