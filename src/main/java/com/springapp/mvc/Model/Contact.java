package com.springapp.mvc.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * Created by ua001022 on 26.11.2015.
 */

@Entity
@Table
@XStreamAlias("Contact")
public class Contact {


    @Id
    @Column
    @GeneratedValue
    @XStreamAlias("ContactId")
    private Long id;


    @NotEmpty
    @Size(min = 4)
    @Column
    @XStreamAlias("Name")
    private String firstName;


    @NotEmpty
    @Size(min = 4)
    @Column
    @XStreamAlias("Surname")
    private String secondName;

    @NotEmpty
    @Size(min = 4)
    @Column
    @XStreamAlias("Patronymic")
    private String patronymic;

    @NotEmpty
    @Column
    @XStreamAlias("MobileNumber")
    private String mobileNumber;

    @XStreamAlias("PhoneNumber")
    private Integer phoneNumber;

    @XStreamAlias("Address")
    private String address;

    @Email()
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @Column
    @XStreamAlias("Email")
    private String email;


    @ManyToOne
    @JoinColumn(name="accountId")
    @XStreamAlias("Account")
    private Account account;

    public Contact() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String lastName) {
        this.patronymic = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
