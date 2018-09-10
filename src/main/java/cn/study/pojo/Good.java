package cn.study.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author asus
 * @date 2018/9/3 16:52
 */
public class Good implements Serializable {

    private static final long serialVersionUID = 517653230976327909L;
    private Integer id;
    private String name;
    private BigDecimal price;
    private String group;
    private Integer inventory;
    private String description;
    private Integer isSale;

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
