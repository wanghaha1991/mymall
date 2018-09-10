package cn.study.service.impl;

import cn.study.mapper.FileMapper;
import cn.study.pojo.Image;
import cn.study.service.FileService;
import cn.study.utils.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author asus
 * @Title: FileServiceImpl
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/3 19:08
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    /**
     * 需要拼接的路径
     */
    private  final String server="http://192.168.154.110:8080";
    @Override
    public String addImg(MultipartFile pictureFile)  throws Exception {
        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf(".")+1);

        byte[] bytes = pictureFile.getBytes();
        String fileLocation = FastDfsUtil.fileUpload(bytes, extName);

        return fileLocation;
    }

    @Override
    public List<Image> getAllImages() {
        return fileMapper.getImages();
    }

    @Override
    public void delImage(Integer id) {
        //服务器删除文件
        String url = fileMapper.getUrlById(id);
        //1是斜杠的位置
        String substring = url.substring(server.length()+1);
        int num = FastDfsUtil.delete(substring);
        if (num != 0) {
            //数据库删除url
            fileMapper.deleteImage(id);
        }
    }
}
