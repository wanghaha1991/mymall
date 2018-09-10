package cn.study.controller;

import cn.study.pojo.User;
import cn.study.service.UserService;
import com.github.pagehelper.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author asus
 * @Title: UserController
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/3 8:55
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user) {
        //shiro的校验
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        token.setRememberMe(true);
        try {
            if (!subject.isAuthenticated()) {
                //登录
                subject.login(token);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "/index";
        }
        return "/main";
    }
    @RequestMapping("/admin")
    public @ResponseBody Map list(int page,int pageSize){
        HashMap<String, Object> map = new HashMap<>();
        List<User> users = userService.getUsers(page,pageSize);
        //总条数
        long total = ((Page) users).getTotal();
       map.put("total",total);
       map.put("rows",users);
       return map;
    }
}
