package cn.study.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author asus
 * @date 2018/9/1 10:47
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5199517934372745396L;
    private Integer id;
    private String name;
    private String password;
    private String department;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
