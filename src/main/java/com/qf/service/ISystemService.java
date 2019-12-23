package com.qf.service;

import com.qf.entity.System;
import org.springframework.web.multipart.MultipartFile;

public interface ISystemService {
    Integer insertSystem(System system);

    //修改系统文件
    Integer updateSystem(System system);

}
