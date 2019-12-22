package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.util.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @program: library
 * @description:图片..文件上传
 * @author: XiongJun
 * @create: 2019-12-22 20:28
 **/
@RestController
public class FileContorller extends Base {

    //@Value("${web.upload-path}") 文件路径
    private String path;

    //@Value("${web.imagePath}") 上传后文件路径
    private String imagePath;

    /**
     * 文件上传
     */
    @PostMapping("/fileUpload")
    public Object upload(@RequestParam("fileName") MultipartFile file){
        String upload = FileUtils.upload(file, this.path, file.getOriginalFilename());
        if(StringUtils.isEmpty(upload)){
            return packaging(StateCode.FAIL,"上传失败",null);
        }else{
            return packaging(StateCode.SUCCESS,"上传成功",imagePath+upload);
        }
    }
}
