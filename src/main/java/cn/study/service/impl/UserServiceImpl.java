package cn.study.service.impl;

import cn.study.mapper.UserMapper;
import cn.study.pojo.User;
import cn.study.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/1 11:14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<User> users = userMapper.getUsers();
        return users;
    }

    @Override
    public User loginCheck(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public List<String> getAllPrivilege(User user) {

        return userMapper.getPrivilegeByUser(user);
    }
}
