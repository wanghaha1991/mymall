package cn.study.pojo;

import java.io.Serializable;

/**
 * @author asus
 * @date 2018/9/1 10:51
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = -1233164013069428606L;
    private int id;
    private String desc;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
