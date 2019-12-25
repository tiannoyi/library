package com.qf.realm;

import com.qf.entity.Admin;
import com.qf.entity.AdminExample;
import com.qf.entity.Permissions;
import com.qf.exception.PassWordIsNullException;
import com.qf.exception.UserNameIsNullException;
import com.qf.mapper.AdminMapper;
import com.qf.service.IPermissionsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-24 16:25
 **/
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private AdminMapper am;

    @Autowired
    private IPermissionsService ps;

    Session session;



    // 权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Permissions> permissions = ps.selectPermissions(((Admin) session.getAttribute("admin")).getRoleId());
        for (Permissions p : permissions) {
            info.addStringPermission(p.getPermissionStr());
        }
        return info;
    }

    // 登陆验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
        // 账号为空
        if (StringUtils.isEmpty(uptoken.getUsername())) {
            throw new UserNameIsNullException();
        }
        // 密码为空
        if (StringUtils.isEmpty((uptoken.getPassword()))) {
            throw new PassWordIsNullException();
        }
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminNameEqualTo(uptoken.getUsername());
        List<Admin> admins = am.selectByExample(example);

        // 账号不存在
        if (StringUtils.isEmpty(admins)) {
            throw new UnknownAccountException();
        }
        Admin admin = admins.get(0);
        session = SecurityUtils.getSubject().getSession();
        session.setAttribute("admin", admin);
        //加盐
        ByteSource bs = ByteSource.Util.bytes(admin.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(uptoken.getPrincipal(), admin.getPassword(), bs,
                getName());

        return info;
    }
}
