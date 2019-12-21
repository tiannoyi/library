package com.qf.service.impl;

import com.qf.entity.BorrowHistoryExample;
import com.qf.entity.Borrows;
import com.qf.entity.BorrowsExample;
import com.qf.mapper.BorrowsMapper;
import com.qf.service.IBorrowsService;
import com.qf.util.ChangliangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunJie
 * @className: BorrowsServiceImpl
 * @description: TODO
 * @createTime: 2019/12/20 15:21
 * @version: 1.0
 */
@Service
public class BorrowsServiceImpl implements IBorrowsService {
    @Autowired
    BorrowsMapper borrowsMapper;


    /**
     * 插入新的查询记录
     *
     * @param borrows 带有数据的 borrows 对象
     * @return 影响行数
     */
    @Override
    public Integer insertBorrows(Borrows borrows) {
        if (borrows.getReaderId() != null && borrows.getReaderId() > 0 && borrows.getBookStateId() != null && borrows.getBookStateId() > 0) {
            return borrowsMapper.insertSelective(borrows);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBorrowsByBorrowId(Integer borrowsId) {
        return getDeleteResult(borrowsId);
    }

    @Override
    public Integer deleteBorrowsByBookStateId(Integer bookStateId) {
        return getDeleteResult(bookStateId);
    }

    /**
     * 抽取的生成对象方法，有点多余
     *
     * @return
     */
    private BorrowsExample getBorrowsExample() {
        return new BorrowsExample();
    }

    /**
     * 抽取的根据 Id 删除对应记录方法
     *
     * @param deleteId
     * @return 删除结果
     */
    private Integer getDeleteResult(Integer deleteId) {
        BorrowsExample borrowsExample = getBorrowsExample();
        BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
        if (deleteId != null && deleteId > 0) {
            Borrows borrows = new Borrows();
            borrowsExampleCriteria.andBorrowIdEqualTo(deleteId);
            borrows.setIsDelete(0);
            return borrowsMapper.updateByExample(borrows, borrowsExample);
        }
        return ChangliangUtil.FAIL;
    }


    @Override
    public Integer updateBorrows(Borrows borrows) {
        if (borrows.getBorrowId() != null && borrows.getBorrowId() > 0) {
            return borrowsMapper.updateByPrimaryKey(borrows);
        }
        return ChangliangUtil.FAIL;
    }


    /**
     * 根据 borrowsId 查询对应借阅事件
     *
     * @param borrowId 借阅事件对应的记录id
     * @return borrowsId 对应的借阅记录
     */
    @Override
    public Borrows selectBorrowsByBorrowId(Integer borrowId) {
        return getBorrows(borrowId);
    }

    @Override
    public Borrows selectBorrowsByBookStateId(Integer bookStateId) {
        return getBorrows(bookStateId);
    }

    /**
     * 抽取的根据 Id 查询单个借阅记录
     *
     * @param selectId
     * @return
     */
    private Borrows getBorrows(Integer selectId) {
        BorrowsExample borrowsExample = getBorrowsExample();
        BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
        if (selectId != null && selectId > 0) {
            borrowsExampleCriteria.andBorrowIdEqualTo(selectId);
            borrowsExampleCriteria.andIsDeleteEqualTo(1);
            List<Borrows> borrowsList = borrowsMapper.selectByExample(borrowsExample);
            return borrowsList.get(0);
        }
        return null;
    }


    /**
     * 查询全部借阅记录
     *
     * @return 全部记录的list
     */
    @Override
    public List<Borrows> selectAll() {
        BorrowsExample borrowsExample = getBorrowsExample();
        BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
        borrowsExampleCriteria.andIsDeleteEqualTo(1);
        return borrowsMapper.selectByExample(borrowsExample);
    }

    /**
     * 全部未删除的借阅记录数量
     *
     * @return
     */
    @Override
    public Integer selectCountAllBorrows() {
        BorrowsExample borrowsExample = getBorrowsExample();
        BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
        borrowsExampleCriteria.andIsDeleteEqualTo(1);
        return borrowsMapper.countByExample(borrowsExample);
    }

}
