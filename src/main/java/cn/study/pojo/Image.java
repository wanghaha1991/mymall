package cn.study.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author asus
 * @Title: Image
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/4 17:52
 */
public class Image implements Serializable {
    private static final long serialVersionUID = -3727500020257209272L;
    private int goodId;
    private int id;
    private String img;
    private String goodName;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
