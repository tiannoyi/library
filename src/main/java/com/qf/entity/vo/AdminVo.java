package com.qf.entity.vo;

import com.qf.entity.Admin;
import com.qf.entity.Roles;
import lombok.Data;

import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-20 09:39
 **/
@Data
public class AdminVo extends Admin {
    private Roles role;
}
