package com.qf.service;

import com.qf.entity.Admin;
import com.qf.entity.AdminExample;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-17 22:03
 **/
public interface IHollowService {
    String sayHollow(String name);
    Admin testMapper();
}
