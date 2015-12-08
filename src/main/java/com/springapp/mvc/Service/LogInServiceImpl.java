package com.springapp.mvc.Service;

import com.springapp.mvc.DAO.LogInDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ua001022 on 07.12.2015.
 */
@Service
public class LogInServiceImpl implements LogInService{

    @Autowired
    private LogInDAO logInDAO;

    @Transactional
    @Override
    public Long authenticate(String login, String password) {
        logInDAO.authenticate(login,password);
        return logInDAO.authenticate(login,password);
    }
}
