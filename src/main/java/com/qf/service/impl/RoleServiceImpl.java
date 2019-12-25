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
import org.springframework.util.StringUtils;

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
        if (StringUtils.isEmpty(currentPage)){
            currentPage = 1;
        }
        if (StringUtils.isEmpty(pageSize)){
            pageSize = systemMapper.getPageLine();
        }
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
    public List<Roles> selectAlls() {
        RolesExample example = new RolesExample();
        example.createCriteria().andIsDeleteEqualTo(1);
        example.setOrderByClause("role_id");
        List<Roles> roles = rolesMapper.selectByExample(example);
        return roles;
    }

    @Override
    public RolesVo selectByPrimaryKeyVo(Integer roleId) {

        return rolesMapper.selectByPrimaryKeyVo(roleId);
    }

    @Override
    public Roles selectByPrimaryKey(Integer roleId) {
        return rolesMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public Integer updateByPrimaryKey(Roles roles) {
        return rolesMapper.updateByPrimaryKeySelective(roles);
    }

    @Override
    public Integer insertRole(Roles role) {
        return  rolesMapper.insertSelective(role);
    }

    @Override
    public Integer deleteRole(Integer id) {
        return rolesMapper.updateByPrimaryKeySelective(new Roles(id,0));
    }
}
