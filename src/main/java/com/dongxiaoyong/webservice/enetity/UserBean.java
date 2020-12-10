package com.dongxiaoyong.webservice.enetity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Create By dongxiaoyong on /2020/12/10
 * description:
 *
 * @author dongxiaoyong
 */
public class UserBean implements Serializable {

    private Timestamp birthdate;
    private String name;
    private String phone;
    private Integer age;

    public UserBean() {
    }

    public UserBean(Timestamp birthdate, String name, String phone, Integer age) {
        this.birthdate = birthdate;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
