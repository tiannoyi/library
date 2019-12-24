package com.qf.controller;


import com.qf.config.ImgesConfig;
import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.System;
import com.qf.service.ISystemService;
import com.qf.util.FileUtils;
import com.qf.util.State;
import com.qf.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/system")
public class SystemController extends Base {
    @Autowired
    ISystemService systemService;

    @Autowired
    ImgesConfig imagePath;
    //修改系统表
    @PostMapping("/updateSystem")
    public Object updateSystem(MultipartFile file,System system, HttpServletRequest request){
        if (!StringUtils.isEmpty(file)) {
            String path = request.getSession().getServletContext().getRealPath(imagePath.getPath());
            String upload = FileUtils.upload(file, path, file.getOriginalFilename());
            Integer id = systemService.updateSystem(upload, system);
            if (id == null) {
                return packaging(StateCode.FAIL,"上传失败",null);
            }else {
                return packaging(StateCode.SUCCESS,"上传成功",id);
            }
        }else {
            Integer id = systemService.updateSystemNoImg(system);
            if (id == null) {
                return packaging(StateCode.FAIL,"上传失败",null);
            }else {
                return packaging(StateCode.SUCCESS,"上传成功",id);
            }
        }

    }

    //查询系统表
    @GetMapping("/selectSystemList")
    public State<Object> selectSystemList(){
        List<System> systems = systemService.selectSystemList();
        if (systems != null) {
            return packaging(StateCode.SUCCESS,"查询成功",systems);
        }else {
            return packaging(StateCode.SUCCESS,"查询失败",null);
        }
    }
}
