package cn.study.service;

import cn.study.pojo.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 图片文件的操作
 * @author asus
 * @date 2018/9/3 19:06
 */
public interface FileService {
    /**
     * 将fastDfs的地址保存至mysql
     * @param  pictureFile 上传文件包装类
     * @throws java.io.IOException 文件读取异常
     * @return  string url
     */
    String addImg(MultipartFile pictureFile)  throws Exception;

    /**
     * 获取images
     * @return list
     */
    List<Image> getAllImages();

    /**
     * 删除图片
     * @param id id
     */
    void delImage(Integer id);
}
