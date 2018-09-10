package cn.study.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author asus
 * @date 2018/9/5 16:57
 */
public class Account implements Serializable{

    private static final long serialVersionUID = -5156541103648722422L;
    private int id;
    private String username;
    private String password;
    private Date birthday;
    private String phone;
    private int gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
