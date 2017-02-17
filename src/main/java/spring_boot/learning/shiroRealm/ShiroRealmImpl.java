package spring_boot.learning.shiroRealm;

import java.util.Arrays;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import spring_boot.learning.domain.Users;
import spring_boot.learning.repository.UsersRepo;

/**
* @author DexterPoker
* @date 2017年1月18日-下午3:26:23
**/
public class ShiroRealmImpl extends AuthorizingRealm{

	@Autowired
    private UsersRepo usersRepo;
 
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Users user = usersRepo.selectById(token.getUsername().toString());
        if (null == user) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(),getName());
    }
 
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        Users user = (Users) principals.getPrimaryPrincipal();
        String roles = user.getRoles();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (!StringUtils.isEmpty(roles)) {
            info.addRoles(Arrays.asList(roles.split(",")));
        }
        return info;
    }

}
