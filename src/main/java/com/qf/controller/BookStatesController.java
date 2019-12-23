package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.BookStates;
import com.qf.service.IBookStatesService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookStates")
public class BookStatesController extends Base {
    @Autowired
    private IBookStatesService bookStatesService;

    @PostMapping("/insertBookStates")
    public State<Object> insertBookStates(BookStates bookStates){
        int i = bookStatesService.insertBookStates(bookStates);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"添加成功",i);
        }else {
            return packaging(StateCode.FAIL,"添加失败",null);
        }
    }

    @PutMapping("/deleteBookStates")
    public State<Object> deleteBookStates(Integer bookStateId){
        int i = bookStatesService.deleteBookStates(bookStateId);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"删除成功",i);
        }else {
            return packaging(StateCode.FAIL,"删除失败",null);
        }
    }

    @PutMapping("/updateBookStates")
    public State<Object> updateBookStates(Integer bookStateId,BookStates bookStates){
        int i = bookStatesService.updateBookStates(bookStateId, bookStates);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"修改成功",i);
        }else {
            return packaging(StateCode.FAIL,"修改失败",null);
        }
    }

    @GetMapping("/selectAllBookStates")//测试可行
    public State<Object> selectAllBookStates(Integer currentPage, Integer pageSize){
        Page<BookStates> bookStatesPage = bookStatesService.selectAllBookStates(currentPage, pageSize);
        if (!bookStatesPage.getList().isEmpty()){
            return packaging(StateCode.SUCCESS,"查询成功",bookStatesPage);
        }else {
            return packaging(StateCode.FAIL,"查询失败",null);
        }
    }

    @GetMapping("/selectStateByBookStateId")//测试可行
    public State<Object> selectStateByBookStateId(Integer bookStateId){
        BookStates bookStates = bookStatesService.selectStateByBookStateId(bookStateId);
        if (bookStates != null){
            return packaging(StateCode.SUCCESS,"查询成功",bookStates);
        }else {
            return packaging(StateCode.FAIL,"查询失败",null);
        }
    }
}
