package cn.study.realm;

import cn.study.mapper.UserMapper;
import cn.study.pojo.User;
import cn.study.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/3 9:07
 */
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection 权限
     * @return 授权的信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("---------授权方法执行了---------");
        //获取当前登录的用户
        User user = (User) principalCollection.getPrimaryPrincipal();
        //获取当前用户的所有权限名
        List<String> privilege = userService.getAllPrivilege(user);
        //授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(privilege);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken controller中传递的token
     * @return authenticationInfo 认证信息
     * @throws AuthenticationException shiro自带异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //通过用户名进行密码的校验
        User user = userService.loginCheck(username);
        //杂质
        ByteSource salt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), salt, this.getName());

        return authenticationInfo;

    }
}
