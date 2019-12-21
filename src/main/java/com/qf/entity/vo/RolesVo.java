package com.qf.entity.vo;

import com.qf.entity.Permissions;
import com.qf.entity.Roles;
import lombok.Data;

import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-21 14:19
 **/
@Data
public class RolesVo extends Roles {
    private List<Permissions> permissions;
}
