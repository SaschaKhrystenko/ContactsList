package com.springapp.mvc.Service;

import com.springapp.mvc.DAO.RegisterDAO;
import com.springapp.mvc.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ua001022 on 06.12.2015.
 */

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDAO RegisterDAO;

    @Transactional
    @Override
    public void register(Account account) {
        RegisterDAO.register(account);
    }

    @Transactional
    @Override
    public boolean isUnique(String login) {
        return RegisterDAO.isUnique(login);
    }
}
