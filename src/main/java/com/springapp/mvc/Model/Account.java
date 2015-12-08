package com.springapp.mvc.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by ua001022 on 04.12.2015.
 */
@Entity
@Table
@XStreamAlias("Account")
public class Account {

    @Id
    @Column
    @GeneratedValue
    @XStreamAlias("AccountId")
    private Long id;

    @Size(min = 3)
    @Pattern(regexp="^[a-zA-Z ]+$")
    @Column
    @XStreamAlias("Login")
    private String login;

    @Size(min = 5)
    @Column
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$")
    @XStreamAlias("Password")
    private String password;

    @Size(min = 5)
    @Column
    @XStreamAlias("FullName")
    private String fullName;



    public Account() {
    }

    public Account( Long id,String login) {
        this.id = id;
        this.login = login;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
