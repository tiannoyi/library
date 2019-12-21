package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.Roles;
import com.qf.entity.RolesExample;
import com.qf.entity.System;
import com.qf.entity.vo.RolesVo;
import com.qf.mapper.RolesMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.IRoleService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-21 14:07
 **/
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RolesMapper rolesMapper;
    @Autowired
    SystemMapper systemMapper;
    @Override
    public Page<Roles> selectAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        RolesExample example = new RolesExample();
        example.createCriteria().andIsDeleteEqualTo(1);
        example.setOrderByClause("role_id desc");
        List<Roles> roles = rolesMapper.selectByExample(example);
        int rolesNum = rolesMapper.countByExample(example);
        Page<Roles> pageData = new Page<>(currentPage, pageSize, rolesNum);
        pageData.setList(roles);
        return pageData;
    }

    @Override
    public RolesVo selectByPrimaryKeyVo(Integer roleId) {
        return null;
    }

    @Override
    public Integer updateByPrimaryKey(Roles roles) {
        return null;
    }

    @Override
    public Integer insertRole(Roles role) {
        return  rolesMapper.insertSelective(role);
    }

    @Override
    public Integer deleteRole(Integer id) {
        return null;
    }
}
