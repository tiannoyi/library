package com.qf.service.impl;

import com.qf.entity.Admin;
import com.qf.entity.vo.AdminVo;
import com.qf.service.IAdminService;
import com.qf.util.Page;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-20 19:19
 **/
@Service
public class AdminServiceImpl implements IAdminService {
    @Override
    public AdminVo selectByPrimaryKeyVo(Integer adminId) {
        return null;
    }

    @Override
    public Page selectAllVo(Integer currentPage, Integer pageSize) {
        return null;
    }

    @Override
    public Integer update(Admin admin) {
        return null;
    }
}
