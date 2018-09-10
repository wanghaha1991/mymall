package cn.study.mapper;

import cn.study.pojo.Order;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/6 15:48
 */
public interface OrderMapper {
    /**
     * 查询所有订单的信息
     * @return orders list
     */
    List<Order> getOrders();

}
