package cn.study.pojo;

import java.io.Serializable;

/**
 * @author asus
 * @date 2018/9/1 11:08
 */
public class Privilege implements Serializable {

    private static final long serialVersionUID = 5242919280249794546L;
    private Integer id;
    private String name;

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
}
