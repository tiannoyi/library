package com.qf.service;

import com.qf.entity.Logs;
import com.qf.util.Page;

public interface ILogService {
   Page selectAll(Integer currentPage, Integer pageSize);

   void insertLog(Logs logs);
}
