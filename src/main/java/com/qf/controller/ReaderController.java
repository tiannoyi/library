package com.qf.controller;


import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Readers;
import com.qf.service.IReaderService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readers")
public class ReaderController extends Base {
    @Autowired
    private IReaderService readerService;

    @PostMapping("/insertReader")
    public State<Object> insertReader(Readers readers){
        int i = readerService.insertReader(readers);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"添加成功",i);
        }else {
            return packaging(StateCode.FAIL,"添加失败",i);
        }
    }

}
