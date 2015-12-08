package com.springapp.mvc.DAO;

/**
 * Created by ua001022 on 06.12.2015.
 */
public interface LogInDAO {
    public Long authenticate(String login, String password);
}
