package com.htf.utils;

import java.util.Date;

/**
 * Created by htf52 on 25-Nov-15.
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private Date birthDate;
    private String phoneNumber;
    private String sex;
    private String imageUrl;
    private String state = "Active";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public final Date getBirthDate() {
        return birthDate;
    }

    public final void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public final String getSex() {
        return sex;
    }

    public final void setSex(String sex) {
        this.sex = sex;
    }

    public final String getImageUrl() {
        return imageUrl;
    }

    public final void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public final String getState() {
        return state;
    }

    public final void setState(String state) {
        this.state = state;
    }
}
