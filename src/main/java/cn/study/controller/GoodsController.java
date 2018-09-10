package cn.study.controller;

import cn.study.pojo.Classify;
import cn.study.pojo.Good;
import cn.study.service.ClassifyService;
import cn.study.service.GoodService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/3 16:44
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("/goods")
    public String getGoods(Model model) {
        List<Good> goodList = goodService.getList();
        model.addAttribute("goods", goodList);
        return "good/list";
    }

    @RequiresPermissions("good_manager")
    @RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Good good = goodService.getGoodById(id);
        //根节点类型
        List<Classify> roots = classifyService.getRoot(0);
        model.addAttribute("good", good);
        model.addAttribute("roots", roots);
        return "good/update";
    }

    @RequiresPermissions("good_manager")
    @RequestMapping(value = "/good", method = RequestMethod.PUT)
    public String update(Good good) {
        goodService.updateGood(good);
        return "redirect:/goods";
    }

    @RequiresPermissions("good_manager")
    @RequestMapping(value = "/good/{id}", method = RequestMethod.DELETE)
    public String delGood(@PathVariable int id) {
        goodService.delGood(id);
        return "good/list";
    }

    @RequestMapping(value = "/good", method = RequestMethod.GET)
    public String addGood(Model model) {
        List<Classify> groups = classifyService.getRoot(0);
        model.addAttribute("groups", groups);
        return "good/add";
    }

    @RequestMapping(value = "/good", method = RequestMethod.POST)
    public String addGood(Good good) {
        goodService.addGood(good);
        return "good/list";
    }

    @RequestMapping(value = "/getInventory",method = RequestMethod.POST)
    public @ResponseBody
    List<Good> chart() {
        List<Good> list = goodService.getList();
        return list;
    }
    @RequestMapping("/sale")
    public String sale(Model model){
        //查询已经上架的
        List<Good> goods = goodService.getGoodsBySale(1);
        model.addAttribute("goods",goods);
        return "good/sale";
    }
    @RequestMapping("/unSale")
    public String unSale(Model model){
        //查询未上架的
        List<Good> goods = goodService.getGoodsBySale(0);
        model.addAttribute("goods",goods);
        return "good/unSale";
    }
    @RequestMapping("/updateSale")
    public @ResponseBody String updateSle(int id,int status){
        goodService.updateSale(id,1^status);
        return "yes";
    }
}
