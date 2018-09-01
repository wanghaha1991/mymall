package cn.study.mapper;

import cn.study.pojo.User;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/1 11:16
 */
public interface UserMapper {
    /**
     * 获取所有的user对象
     * @return list
     */
    List<User> getUsers();
}
