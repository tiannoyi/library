package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Admin;
import com.qf.exception.NotLoginException;
import com.qf.exception.PassWordErrorException;
import com.qf.exception.SystemErrorException;
import com.qf.exception.UserNameExistException;
import com.qf.service.IAdminService;
import com.qf.util.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-20 19:17
 **/
@RestController
public class AdminController extends Base {
    @Autowired
    IAdminService as;

    @GetMapping("/admins")
    public Object selectAll(Integer currentPage,  Integer pageSize) {
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        Page data = as.selectAllVo(currentPage, pageSize);
        return packaging(StateCode.SUCCESS,"查询成功", data);
    }

    @GetMapping("/admins/{id}")
    public Object selectByPrimaryKey(@PathVariable("id") Integer id) {
        return packaging(StateCode.SUCCESS,"查询成功",as.selectByPrimaryKeyVo(id));
    }

    @PostMapping("/admins")
    public Object insert(Admin admin) {
        try {
            admin = as.insertAdmin(admin);
            return packaging(StateCode.SUCCESS,"添加",admin);
        } catch (UserNameExistException e) {
            return packaging(StateCode.USERNAMEEXIST,"用户名已经存在", admin);
        } catch (SystemErrorException e) {
            return packaging(StateCode.FAIL,"添加失败", admin);
        }
    }

    @PutMapping("admins/{id}")
    public Object update(@PathVariable("id") Integer id,@RequestBody Admin admin) {
        admin.setAdminId(id);
        return packaging(StateCode.SUCCESS,"修改成功",as.update(admin));
    }

    @PutMapping("/admins/update_password")
    public Object updatePassword(@RequestBody Map<String,String> map) {
        try {
            return packaging(StateCode.SUCCESS,"修改密码成功",as.changePassword(map));
        } catch (NotLoginException e) {
            return packaging(StateCode.LOGINAGAIN,"请重新登录",null);
        } catch (PassWordErrorException e) {
            return packaging(StateCode.PASSWORDMISTAKE,"密码错误",map.get("oldoldPassword"));
        }

    }

    @DeleteMapping("/admins/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        int i = as.deleteAdmin(id);
        if (i > 0){
            return packaging(StateCode.SUCCESS,"删除成功",null);
        } else{
            return packaging(StateCode.FAIL,"删除失败",null);
        }
    }

    @DeleteMapping("/admins/ids/{adminIds}")
    public Object deletes(@PathVariable String adminIds){
        if (StringUtils.isEmpty(adminIds)){
            return packaging(StateCode.FAIL,"删除失败",null);
        }
        String[] split = adminIds.split(",");
        for (int i = 0; i < split.length; i++) {
            as.deleteAdmin(Integer.parseInt(split[i]));
        }
        return packaging(StateCode.SUCCESS,"删除成功",adminIds);
    }

    @GetMapping("/admins/checkUsername")
    public Map checkUsername(@RequestParam String username){
        Map<String, Boolean> map = new HashMap<>();
        if (StringUtils.isEmpty(username)){
            map.put("valid",true);
            return map;
        }
        Integer integer = as.checkUsername(username);
        if (integer == 0){
            map.put("valid",true);
            return map;
        }
        map.put("valid",false);
        return map;
    }

}
