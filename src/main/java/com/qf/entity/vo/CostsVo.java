package com.qf.entity.vo;

import com.qf.entity.Costs;
import com.qf.entity.Readers;
import lombok.Data;

@Data
public class CostsVo extends Costs {
    private Readers reader;
}