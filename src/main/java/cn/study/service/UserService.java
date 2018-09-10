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
    List<User> getUsers(int page,int pageSize);

    /**
     * login check
     * @param name username
     * @return User
     */
    User loginCheck(String name);

    /**
     * 查询用户拥有的权限
     * @param user 个体
     * @return list 权限集合
     */
    List<String> getAllPrivilege(User user);
}
