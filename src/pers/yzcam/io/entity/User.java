package pers.yzcam.io.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实现 Serializable 接口的类是序列化类
 *
 * @author cat
 */
public class User implements Serializable {

    private static String dec = "使用者";
    private String id;
    private String name;
    private String gender;
    private Date birth;
    private String address;

    public User() {
    }

    public User(String id, String name, String gender, Date birth, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
    }

    public static String getDec() {
        return dec;
    }

    public static void setDec(String dec) {
        User.dec = dec;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
