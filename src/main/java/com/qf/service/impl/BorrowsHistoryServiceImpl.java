package com.qf.service.impl;

import com.qf.entity.BorrowHistory;
import com.qf.entity.BorrowHistoryExample;
import com.qf.entity.BorrowsExample;
import com.qf.mapper.BorrowHistoryMapper;
import com.qf.service.IBorrowHistoryService;
import com.qf.service.IBorrowsService;
import com.qf.util.ChangliangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunJie
 * @classBelongTo: library.com.qf.service.impl
 * @description: TODO
 * @createTime: 2019/12/20 22:49
 * @version: 1.0
 */
@Service
public class BorrowsHistoryServiceImpl implements IBorrowHistoryService {
    @Autowired
    BorrowHistoryMapper borrowHistoryMapper;

    @Override
    public Integer insertBorrowHistory(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() != null && borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() != null && borrowHistory.getBookId() > 0
                && borrowHistory.getBorrowTime() != null
        ) {
            return borrowHistoryMapper.insert(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBorrowHistoryByHistoryId(Integer historyId) {
        return null;
    }

    @Override
    public Integer deleteBorrowHistoryByBookId(Integer bookId) {
        return null;
    }

    @Override
    public Integer deleteBorrowHistoryByReaderId(Integer readerId) {
        return null;
    }

    @Override
    public Integer updateBorrow(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() > 0
                && borrowHistory.getHistoryId() != null
        ){
           return borrowHistoryMapper.updateByPrimaryKey(borrowHistory);
        }
            return ChangliangUtil.FAIL;
    }

    @Override
    public List<BorrowHistory> selectBorrowHistoryByReaderId(Integer readerId) {
        return null;
    }

    @Override
    public List<BorrowHistory> selectBorrowHistoryByBookId(Integer bookId) {
        return null;
    }
}
