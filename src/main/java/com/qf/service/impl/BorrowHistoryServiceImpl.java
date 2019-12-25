package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.BorrowHistory;
import com.qf.entity.BorrowHistoryExample;
import com.qf.mapper.BorrowHistoryMapper;
import com.qf.service.IBorrowHistoryService;
import com.qf.util.ChangliangUtil;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author: JunJie
 * @classBelongTo: library.com.qf.service.impl
 * @description: TODO
 * @createTime: 2019/12/20 22:49
 * @version: 1.0
 */
@Service
public class BorrowHistoryServiceImpl implements IBorrowHistoryService {
    @Autowired
    BorrowHistoryMapper borrowHistoryMapper;

    @Override
    public Integer insertBorrowHistory(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() != null && borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() != null && borrowHistory.getBookId() > 0
        ) {
            return borrowHistoryMapper.insertSelective(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer updateBorrowHistoryByHistoryId(BorrowHistory borrowHistory) {
        if (borrowHistory.getHistoryId() != null && borrowHistory.getHistoryId() > 0
        ) {
            return borrowHistoryMapper.updateByPrimaryKeySelective(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer updateBorrowHistoryByReaderIdAndBookId(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() != null && borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() != null && borrowHistory.getBookId() > 0
        ) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            borrowHistoryExample.createCriteria().andReaderIdEqualTo(borrowHistory.getReaderId()).andBookIdEqualTo(borrowHistory.getBookId());
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public BorrowHistory selectBorrowHistoryByHistoryId(Integer historyId) {
        if (historyId != null && historyId > 0) {
            return borrowHistoryMapper.selectByPrimaryKey(historyId);
        }
        return null;
    }

    /**
     * 抽取的重复方法
     *
     * @param currentPage
     * @param pageSize
     * @param borrowHistoryExample
     * @return
     */
    private Page<BorrowHistory> getPage(Integer currentPage, Integer pageSize, BorrowHistoryExample borrowHistoryExample) {
        List<BorrowHistory> borrowHistories = borrowHistoryMapper.selectByExample(borrowHistoryExample);
        int totalCount = borrowHistoryMapper.countByExample(borrowHistoryExample);
        if (!borrowHistories.isEmpty()) {
            Page<BorrowHistory> page = new Page<>(currentPage, pageSize, totalCount);
            page.setList(borrowHistories);
            return page;
        }
        return null;
    }


    @Override
    public Page<BorrowHistory> selectBorrowHistoryByReaderId(Integer readerId, Integer currentPage, Integer pageSize) {
        if (readerId != null && readerId > 0) {
            PageHelper.startPage(currentPage, pageSize);

            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            borrowHistoryExample.createCriteria().andReaderIdEqualTo(readerId).andIsDeleteEqualTo(1);
            return getPage(currentPage, pageSize, borrowHistoryExample);
        }
        return null;
    }


    @Override
    public Page<BorrowHistory> selectBorrowHistoryByBookId(Integer bookId, Integer currentPage, Integer pageSize) {
        if (bookId != null && bookId > 0) {
            PageHelper.startPage(currentPage, pageSize);
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            borrowHistoryExample.createCriteria().andBookIdEqualTo(bookId).andIsDeleteEqualTo(1);
            return getPage(currentPage, pageSize, borrowHistoryExample);
        }
        return null;
    }

    @Override
    public Integer deleteBorrowHistoryByHistoryId(Integer historyId) {
        if (historyId != null && historyId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            borrowHistoryExample.createCriteria().andIsDeleteEqualTo(1).andHistoryIdEqualTo(historyId);
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBorrowHistoryByBookId(Integer bookId) {
        if (bookId != null && bookId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            borrowHistoryExample.createCriteria().andIsDeleteEqualTo(1).andBookIdEqualTo(bookId);
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }


    @Override
    public Integer deleteBorrowHistoryByReaderId(Integer readerId) {
        if (readerId != null && readerId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            borrowHistoryExample.createCriteria().andReaderIdEqualTo(readerId).andIsDeleteEqualTo(1);
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBatchByHistoryId(Integer[] borrowHistoryIds) {
        int deleteCount = 0;
        if (!StringUtils.isEmpty(borrowHistoryIds) && borrowHistoryIds.length > 0) {
            for (Integer historyId : borrowHistoryIds) {
                BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
                borrowHistoryExample.createCriteria().andHistoryIdEqualTo(historyId).andIsDeleteEqualTo(1);
                BorrowHistory borrowHistory = new BorrowHistory();
                borrowHistory.setIsDelete(0);
                if (borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample) == 1) {
                    deleteCount++;
                }
            }
        }
        return deleteCount;
    }


    @Override
    public Page<BorrowHistory> selectAllUnDeleteBorrowHistory(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
        borrowHistoryExample.createCriteria().andIsDeleteEqualTo(1);
        return getPage(currentPage, pageSize, borrowHistoryExample);
    }


    @Override
    public Page<BorrowHistory> selectAllBorrowHistory(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
        return getPage(currentPage, pageSize, borrowHistoryExample);
    }


    @Override
    public Integer selectCountAllBorrowHistory() {
        BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
        borrowHistoryExample.createCriteria().andIsDeleteEqualTo(1);
        return borrowHistoryMapper.countByExample(borrowHistoryExample);
    }
}