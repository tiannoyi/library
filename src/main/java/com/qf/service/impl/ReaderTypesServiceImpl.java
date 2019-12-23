package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.ReaderTypes;
import com.qf.entity.ReaderTypesExample;
import com.qf.mapper.ReaderTypesMapper;
import com.qf.service.IReaderTypeService;
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
 * @createTime: 2019/12/23 9:28
 * @version: 1.0
 */
@Service
public class ReaderTypesServiceImpl implements IReaderTypeService {
    @Autowired
    ReaderTypesMapper readerTypesMapper;

    @Override
    public Integer insertReaderTypes(ReaderTypes readerTypes) {
        if (readerTypes.getReaderTypeName() != null && !"".equals(readerTypes.getReaderTypeName())) {
            return readerTypesMapper.insertSelective(readerTypes);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteReaderTypesByReaderTypeId(Integer readerTypeId) {
        if (readerTypeId != null && readerTypeId > 0) {
            ReaderTypesExample readerTypesExample = new ReaderTypesExample();
            ReaderTypesExample.Criteria readerTypesExampleCriteria = readerTypesExample.createCriteria();
            readerTypesExampleCriteria.andIsDeleteEqualTo(1);
            readerTypesExampleCriteria.andReaderTypeIdEqualTo(readerTypeId);
            ReaderTypes readerTypes = new ReaderTypes();
            readerTypes.setIsDelete(0);
            return readerTypesMapper.updateByExampleSelective(readerTypes, readerTypesExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteReaderTypesByReaderTypeName(String readerTypeName) {
        if (readerTypeName != null && !"".equals(readerTypeName)) {
            ReaderTypesExample readerTypesExample = new ReaderTypesExample();
            ReaderTypesExample.Criteria readerTypesExampleCriteria = readerTypesExample.createCriteria();
            readerTypesExampleCriteria.andIsDeleteEqualTo(1);
            readerTypesExampleCriteria.andReaderTypeNameEqualTo(readerTypeName);
            ReaderTypes readerTypes = new ReaderTypes();
            readerTypes.setIsDelete(0);
            return readerTypesMapper.updateByExampleSelective(readerTypes, readerTypesExample);
        }
        return null;
    }

    @Override
    public Integer deleteBatchReaderTypesById(Integer[] deleteIds) {
        int deleteCount = 0;
        if (!StringUtils.isEmpty(deleteIds) && deleteIds.length > 0) {
            for (Integer readerTypeId : deleteIds) {
                ReaderTypesExample readerTypesExample = new ReaderTypesExample();
                ReaderTypesExample.Criteria readerTypesExampleCriteria = readerTypesExample.createCriteria();
                readerTypesExampleCriteria.andIsDeleteEqualTo(1);
                readerTypesExampleCriteria.andReaderTypeIdEqualTo(readerTypeId);
                ReaderTypes readerTypes = new ReaderTypes();
                readerTypes.setIsDelete(0);
                if (readerTypesMapper.updateByExampleSelective(readerTypes, readerTypesExample) == 1) {
                    deleteCount++;
                }
            }
        }
        return deleteCount;
    }

    @Override
    public Integer updateReaderTypesByReadTypeId(ReaderTypes readerTypes) {
        if (readerTypes != null && readerTypes.getReaderTypeId() != null
                && readerTypes.getReaderTypeId() > 0) {
            return readerTypesMapper.updateByPrimaryKeySelective(readerTypes);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public ReaderTypes selectReaderTypesByReadTypeId(Integer readerTypeId) {
        if (readerTypeId != null && readerTypeId > 0) {
            return readerTypesMapper.selectByPrimaryKey(readerTypeId);
        }
        return null;
    }

    private Page<ReaderTypes> getPage(Integer currentPage, Integer pageSize, ReaderTypesExample readerTypesExample) {
        List<ReaderTypes> readerTypes = readerTypesMapper.selectByExample(readerTypesExample);
        int totalCount = readerTypesMapper.countByExample(readerTypesExample);
        if (!readerTypes.isEmpty()) {
            Page<ReaderTypes> page = new Page<>(currentPage, pageSize, totalCount);
            page.setList(readerTypes);
            return page;
        }
        return null;
    }

    @Override
    public Page<ReaderTypes> selectReaderTypesByReaderTypeName(String readerTypeName, Integer currentPage, Integer pageSize) {
        if (readerTypeName != null && !"".equals(readerTypeName)) {
            PageHelper.startPage(currentPage, pageSize);
            ReaderTypesExample readerTypesExample = new ReaderTypesExample();
            readerTypesExample.createCriteria().andReaderTypeNameEqualTo(readerTypeName).andIsDeleteEqualTo(1);
            return getPage(currentPage, pageSize, readerTypesExample);
        }
        return null;
    }

    @Override
    public Page<ReaderTypes> selectAllReaderTypes(Integer currentPage, Integer pageSize) {
        return getPage(currentPage, pageSize, new ReaderTypesExample());
    }

    @Override
    public Page<ReaderTypes> selectAllUnDeleteReaderTypes(Integer currentPage, Integer pageSize) {
        ReaderTypesExample readerTypesExample = new ReaderTypesExample();
        readerTypesExample.createCriteria().andIsDeleteEqualTo(1);
        return getPage(currentPage, pageSize, readerTypesExample);
    }


    @Override
    public Integer selectCountUnDeleteReaderTypes() {
        ReaderTypesExample readerTypesExample = new ReaderTypesExample();
        ReaderTypesExample.Criteria readerTypesExampleCriteria = readerTypesExample.createCriteria();
        readerTypesExampleCriteria.andIsDeleteEqualTo(1);
        return readerTypesMapper.countByExample(readerTypesExample);
    }
}
