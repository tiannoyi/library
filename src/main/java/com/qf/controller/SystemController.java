package com.qf.controller;


import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.System;
import com.qf.service.ISystemService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/system")
public class SystemController extends Base {
    @Autowired
    ISystemService systemService;

    @PutMapping("/updateSystem")
    public State<Object> updateSystem(MultipartFile pic, System system, HttpServletRequest request){
        if (pic != null) {
            String path = request.getSession().getServletContext().getRealPath("/image");
            System sys = new System();
            File file = new File(path);
            if (!file.exists() && !file.isDirectory()) {
                file.mkdir();
            }
            String filename = pic.getOriginalFilename();
            filename = UUID.randomUUID().toString()+"_"+filename;
            try {
                pic.transferTo(new File(file , filename));
                sys.setSysImg("/image"+filename);
                Integer i = systemService.updateSystem(system);
                return packaging(StateCode.SUCCESS,"修改成功", i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return packaging(StateCode.FAIL,"修改失败",null);
        }else {
            Integer i = systemService.updateSystem(system);
            if (i != null) {
                return packaging(StateCode.SUCCESS,"修改成功",i);
            }else {
                return packaging(StateCode.SUCCESS,"修改失败",null);
            }

        }

    }
}
