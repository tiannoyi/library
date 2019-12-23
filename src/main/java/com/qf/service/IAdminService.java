package com.qf.service;

import com.qf.entity.Admin;
import com.qf.entity.vo.AdminVo;
import com.qf.exception.NotLoginException;
import com.qf.exception.PassWordErrorException;
import com.qf.exception.SystemErrorException;
import com.qf.exception.UserNameExistException;
import com.qf.util.Page;

import java.util.Map;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-20 19:18
 **/
public interface IAdminService {
    //查询指定id的用户信息
    AdminVo selectByPrimaryKeyVo(Integer adminId);

    //查询所有用户信息并分页
    Page selectAllVo(Integer currentPage,Integer pageSize);

    //修改用户信息
    Integer update(Admin admin);

    //修改自己密码
    Integer changePassword(Map<String,String> map) throws NotLoginException, PassWordErrorException;

    //新增管理员
    Admin insertAdmin(Admin admin) throws SystemErrorException, UserNameExistException;

    //删除管理员
    Integer deleteAdmin(Integer adminId);

}
