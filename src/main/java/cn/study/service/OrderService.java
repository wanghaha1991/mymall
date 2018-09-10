package cn.study.service;

import cn.study.pojo.Order;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/6 15:50
 */
public interface OrderService {
    /**
     * 查询订单
     * @return list
     */
    List<Order> getOrders();
}
