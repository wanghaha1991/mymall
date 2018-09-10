package cn.study.mapper;

import cn.study.pojo.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author asus
 * @Title: FileMapper
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/3 19:09
 */
public interface FileMapper {
    /**
     * save img src to mysql
     * @param img location
     * @param id good id
     */
    void addImgLocation(@Param("img") String img,@Param("id") Integer id);

    /**
     * 获取所有图片信息
     * @return list of images
     */
    List<Image> getImages();

    /**
     * 删除图片
     * @param id id
     */
    void deleteImage(Integer id);

    /**
     * 获取url
     * @param id id
     * @return url
     */
    String getUrlById(Integer id);
}
