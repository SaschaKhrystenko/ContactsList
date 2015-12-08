package com.springapp.mvc.Service;

import com.springapp.mvc.Model.Account;

/**
 * Created by ua001022 on 06.12.2015.
 */
public interface RegisterService {

    public void register (Account account);
    public boolean isUnique(String login);
}
