package com.springapp.mvc.DAO;

import com.springapp.mvc.Model.Account;


public interface RegisterDAO {
    public void register (Account account);
    public boolean isUnique(String login);

}
