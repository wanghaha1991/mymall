package cn.study.controller;

import cn.study.pojo.Classify;
import cn.study.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/6 9:05
 */
@Controller
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("/classify")
    public String list(Model model) {
        List<Classify> classifies = classifyService.getAll();
        model.addAttribute("classifies", classifies);
        return "classify/list";
    }

    @RequestMapping(value = "/classify/{id}", method = RequestMethod.GET)
    private String update(@PathVariable int id, Model model) {
        Classify classify = classifyService.getClassifyById(id);
        //一级根类别
        List<Classify> roots = classifyService.getRoot(0);
        model.addAttribute("classify", classify);
        model.addAttribute("roots", roots);
        return "classify/update";
    }

    @RequestMapping("/getClassifies")
    private @ResponseBody
    List<Classify> getChildren(int parentId) {
        return classifyService.getChildren(parentId);
    }

    @RequestMapping(value = "/classify", method = RequestMethod.PUT)
    private String update(Classify classify) {
        classifyService.updateClassify(classify);
        return "classify/list";
    }
    @RequestMapping("/classifyFather")
    public String addFather(){
        return "classify/addFather";
    }
    @RequestMapping("/classifyChild")
    public String addChild(Model model){
        List<Classify> roots = classifyService.getRoot(0);
        model.addAttribute("roots",roots);
        return "classify/addChild";
    }
    @RequestMapping(value = "/classify",method = RequestMethod.POST)
    public String addClassify(Classify classify){
        classifyService.addClassify(classify);
        return "redirect:/classify";
    }

}
