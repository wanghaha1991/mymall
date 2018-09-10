package cn.study.pojo;

import java.io.Serializable;

/**
 * @author asus
 * @Title: Classify
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/6 9:06
 */
public class Classify implements Serializable {

    private static final long serialVersionUID = 5992487568239615476L;
    private int id;
    private String name;
    private String description;
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
