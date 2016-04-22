package com.springapp.mvc.Service;

import com.springapp.mvc.DAO.LogInDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LogInServiceImpl implements LogInService{

    @Autowired
    private LogInDAO logInDAO;

    @Transactional
    @Override
    public Long authenticate(String login, String password) {
        return logInDAO.authenticate(login,password);
    }
}
