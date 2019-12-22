package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.BookTypes;
import com.qf.service.IBookTypesService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookTypes")
public class BookTypesController extends Base {
    @Autowired
    private IBookTypesService bookTypesService;

    @PostMapping("/insertBookTypes")
    public State<Object> insertBookTypes(BookTypes bookTypes){
        int i = bookTypesService.insertBookTypes(bookTypes);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"添加成功",i);
        }else {
            return packaging(StateCode.FAIL,"添加失败",null);
        }
    }

    @GetMapping("/selectAllBookTypes")
    public State<Object> selectAllBookTypes(Integer currentPage,Integer pageSize){
        Page<BookTypes> page = bookTypesService.selectAllBookTypes(currentPage, pageSize);
        if (page.getList().isEmpty()){
            return packaging(StateCode.FAIL,"查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"查询成功",page);
        }
    }

    @PutMapping("/deleteBookTypes")
    public State<Object> deleteBookTypes(Integer bookTypeId){
        int i = bookTypesService.deleteBookTypes(bookTypeId);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"删除成功",i);
        }else {
            return packaging(StateCode.FAIL,"删除失败",null);
        }
    }

    @PutMapping("/updateBookTypes")
    public State<Object> updateBookTypes(Integer bookTypeId,BookTypes bookTypes){
        int i = bookTypesService.updateBookTypes(bookTypeId, bookTypes);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"修改成功",i);
        }else {
            return packaging(StateCode.FAIL,"修改失败",null);
        }
    }
}
