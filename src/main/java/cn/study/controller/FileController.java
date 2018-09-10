package cn.study.controller;

import cn.study.pojo.Image;
import cn.study.service.FileService;
import cn.study.utils.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author asus
 * @date 2018/9/3 18:02
 */
@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * ck editer的图片编辑
     * @param pictureFile
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateItem")
    public @ResponseBody String updateItemById(@RequestParam("upload")MultipartFile pictureFile, String CKEditorFuncNum) throws Exception {
        String url = fileService.addImg(pictureFile);
        StringBuffer buffer = new StringBuffer("<script type=\"text/javascript\">");
        buffer.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" + url + "','')")
                .append("</script>");
        return buffer.toString();
    }
    @RequestMapping("/imgManager")
    public String getImages(Model model){
        List<Image> images = fileService.getAllImages();
        model.addAttribute("images",images);
        return "good/image";
    }
    @RequestMapping("/delImage")
    public String delImage(int id){
        fileService.delImage(id);
        return "good/image";
    }
}
