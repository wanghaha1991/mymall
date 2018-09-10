package cn.study.controller;

import cn.study.pojo.Order;
import cn.study.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author asus
 * @Title: Order
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/6 15:38
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/orders")
    public String list(Model model){
        List<Order> orders = orderService.getOrders();
        model.addAttribute("orders",orders);
        return "order/list";
    }
}
