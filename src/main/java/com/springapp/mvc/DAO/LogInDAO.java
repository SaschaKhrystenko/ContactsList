package com.springapp.mvc.DAO;


public interface LogInDAO {
    public Long authenticate(String login, String password);
}
