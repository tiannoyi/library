package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.service.ILogService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-25 20:58
 **/
@RestController
public class LogController extends Base {

    @Autowired
    ILogService logService;

    @GetMapping("/logs")
    public Object selectAll(Integer currentPage, Integer pageSize){
        Page page = logService.selectAll(currentPage, pageSize);
        if (StringUtils.isEmpty(page)){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        return packaging(StateCode.SUCCESS,"查询成功",page);
    }

}
