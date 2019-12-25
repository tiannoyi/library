package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.Admin;
import com.qf.entity.AdminExample;
import com.qf.entity.System;
import com.qf.entity.vo.AdminVo;
import com.qf.exception.NotLoginException;
import com.qf.exception.PassWordErrorException;
import com.qf.exception.SystemErrorException;
import com.qf.exception.UserNameExistException;
import com.qf.mapper.AdminMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.IAdminService;
import com.qf.util.EncryptUtil;
import com.qf.util.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-20 19:19
 **/
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    SystemMapper systemMapper;


    @Override
    public AdminVo selectByPrimaryKeyVo(Integer adminId) {
        return adminMapper.selectByPrimaryKeyVo(adminId);
    }

    @Override
    public Page selectAllVo(Integer currentPage, Integer pageSize) {
        if(pageSize == null)
            pageSize = systemMapper.getPageLine();
        if (currentPage == null)
            currentPage = 1;
        PageHelper.startPage(currentPage, pageSize);
        List<AdminVo> adminVos = adminMapper.selectAllVo();
       /* AdminExample example = new AdminExample();
        example.createCriteria().andIsDeleteEqualTo(1);
        List<Admin> admins = adminMapper.selectByExample(example);*/
        Integer count = adminVos.size();
        Page<AdminVo> pageData = new Page<>(currentPage, pageSize, count);
        pageData.setList(adminVos);
        return pageData;
    }

    @Override
    public Integer update(Admin admin) {
        admin.setSalt(null);
        if (!StringUtils.isEmpty(admin.getPassword())) {
            Map<String, String> map = EncryptUtil.encryption(admin.getPassword());
            admin.setSalt(map.get("salt"));
            admin.setPassword(map.get("password"));
        }
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public Integer changePassword(Map<String, String> map) throws NotLoginException, PassWordErrorException {
        Admin admin = (Admin) SecurityUtils.getSubject().getSession().getAttribute("admin");
        int i = 0;
        if (admin != null) {
            //把输入的密码加密和session里的密码对比
            Map<String, String> old_map = EncryptUtil.encryption(map.get("oldPassword"), admin.getSalt());
            String old_password = old_map.get("password");
            if (admin.getPassword().equals(old_password)) {
                i = update(new Admin(admin.getAdminId(),map.get("newPassword")));
            } else {
                throw new PassWordErrorException("密码错误");
            }
        } else {
            throw new NotLoginException("重新登录");
        }
        return i;
    }

    @Override
    public Admin insertAdmin(Admin admin) throws SystemErrorException, UserNameExistException {
        admin.setAdminId(null);
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminNameEqualTo( admin.getAdminName());
        if (adminMapper.countByExample(example) != 0) {
            throw new UserNameExistException("用户名已经存在");
        } else {
            Map<String, String> map = EncryptUtil.encryption(admin.getPassword());
            admin.setPassword(map.get("password"));
            admin.setSalt(map.get("salt"));

            if (adminMapper.insertSelective(admin) > 0) {
                return admin;
            } else {
                throw new SystemErrorException("插入失败");
            }
        }
    }

    @Override
    public Integer deleteAdmin(Integer adminId) {
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setIsDelete(0);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public Integer checkUsername(String userName) {
        AdminExample example = new AdminExample();
        example.createCriteria().andAdminNameEqualTo(userName);
        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins.size() < 1){
            return 0;
        }
        return 1;
    }
}
