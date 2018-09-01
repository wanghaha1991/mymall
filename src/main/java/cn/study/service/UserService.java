package cn.study.service;

import cn.study.pojo.User;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/1 11:12
 */
public interface UserService {
    /**
     * 获取所有的用户
     * @return list
     */
    List<User> getUsers();

}
