package com.springapp.mvc.Service;

import com.springapp.mvc.Model.Account;

public interface RegisterService {

    public void register (Account account);
    public boolean isUnique(String login);
}
