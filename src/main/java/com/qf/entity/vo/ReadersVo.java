package com.qf.entity.vo;

import com.qf.entity.ReaderTypes;
import com.qf.entity.Readers;
import com.qf.entity.Roles;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReadersVo extends Readers {
    private ReaderTypes readerTypes;
    private Roles roles;
}
