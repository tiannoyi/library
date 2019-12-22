package com.qf.entity.vo;

import com.qf.entity.Permissions;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 21:03
 **/
public class Menu {
    private Permissions permissions;
    private List<Permissions> list = new ArrayList<Permissions>();

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public List<Permissions> getList() {
        return list;
    }

    public void setList(List<Permissions> list) {
        this.list = list;
    }

}
