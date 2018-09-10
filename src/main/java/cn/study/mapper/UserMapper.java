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

    /**
     * get user by name
     * @param name username
     * @return user
     */
    User getUserByName(String name);

    /**
     * get privilege by user
     * @param user 个体
     * @return 权限集合
     */
    List<String> getPrivilegeByUser(User user);
}
