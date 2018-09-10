package cn.study.service.impl;

import cn.study.mapper.OrderMapper;
import cn.study.pojo.Order;
import cn.study.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/6 15:51
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }
}
