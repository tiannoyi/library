package com.qf.controller;


import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Readers;
import com.qf.mapper.SystemMapper;
import com.qf.service.IReadersService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/readers")
public class ReadersController extends Base {
    @Autowired
    private IReadersService readerService;
    @Autowired
    private SystemMapper systemMapper;

    @PostMapping("/insertReader")
    public State<Object> insertReader(Readers readers){
        int i = readerService.insertReader(readers);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"添加成功",i);
        }else {
            return packaging(StateCode.FAIL,"添加失败",null);
        }
    }

    @PutMapping("/deleteReader")
    public State<Object> deleteReader(Integer readerId){
        int i = readerService.deleteReaderById(readerId);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"删除成功",i);
        }else {
            return packaging(StateCode.FAIL,"删除失败",null);
        }
    }

    @PutMapping("/deleteBatch")
    public State<Object> deleteBatch(int [] readerIds){
        int i = readerService.deleteBatch(readerIds);
        if (i == readerIds.length){
            return packaging(StateCode.SUCCESS,"删除成功",i);
        }else {
            return packaging(StateCode.FAIL,"删除失败",null);
        }
    }

    @PutMapping("/updateReader")
    public State<Object> updateReader(Integer readerId,Readers readers){
        int i = readerService.updateReaderById(readerId, readers);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"修改成功",i);
        }else {
            return packaging(StateCode.FAIL,"修改失败",null);
        }
    }

    @GetMapping("/selectAllReaders")//测试可行
    public State<Object> selectAllReaders(Integer currentPage,Integer pageSize){
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<Readers> page = readerService.selectAllReaders(currentPage, pageSize);
        if (page.getList().isEmpty()){
            return packaging(StateCode.FAIL,"查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"查询成功",page);
        }
    }

    @GetMapping("/selectReaderByCondition")//已测试可行
    public State<Object> selectReaderByCondition(Integer currentPage,Integer pageSize,Readers readers){
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<Readers> page = readerService.selectReaderByCondition(currentPage, pageSize, readers);
        if (page.getList().isEmpty()){
            return packaging(StateCode.FAIL,"查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"查询成功",page);
        }
    }
}
