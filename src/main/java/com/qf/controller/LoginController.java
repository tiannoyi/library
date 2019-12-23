package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.entity.Admin;
import com.qf.exception.NotLoginException;
import com.qf.exception.PassWordIsNullException;
import com.qf.exception.SystemErrorException;
import com.qf.exception.UserNameIsNullException;
import com.qf.controller.base.Base;
import com.qf.entity.Admin;
import com.qf.exception.PassWordIsNullException;
import com.qf.exception.UserNameIsNullException;
import com.qf.service.IPermissionsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController extends Base {
    @Autowired
    IPermissionsService ps;



    //管理员登录
    @PostMapping("/login")
    public Object login(Admin admin) throws UserNameIsNullException, PassWordIsNullException {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminName(), admin.getPassword());
        try {
            subject.login(token);
        } catch (UserNameIsNullException uine) {
            return packaging(StateCode.USERNAMENOTNULL,"用户名不能为空", token.getUsername());
        } catch (PassWordIsNullException pine) {
            return packaging(StateCode.PASSWORDNOTNULL,"密码不能为空",token.getUsername());
        } catch (UnknownAccountException uae) {
            return packaging(StateCode.USERNAMENOTEXIST,"用户名不存在",token.getUsername());
        } catch (IncorrectCredentialsException ice) {
            return packaging(StateCode.PASSWORDMISTAKE,"密码错误", token.getUsername());
        } catch (LockedAccountException lae) {
            return packaging(StateCode.USERNAMELOCK,"该账户被冻结", token.getUsername());
        } catch (AuthenticationException ae) {
            return packaging(StateCode.FAIL,"登陆失败", token.getUsername());
        }
        return packaging(StateCode.SUCCESS,"登陆成功", token.getUsername());
    }

    @GetMapping("/menu")
    public Object menu() {
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        try {
            return packaging(StateCode.SUCCESS,"查询菜单成功", ps.selectMenu());
        } catch (NotLoginException e) {
            return packaging(StateCode.LOGINAGAIN,"请重新登陆", null);
        }
    }
}
