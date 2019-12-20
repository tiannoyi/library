package com.xiong.test;

import com.qf.entity.Readers;
import com.qf.service.IReaderService;
import com.xiong.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class ReaderServiceImplTest {
    @Autowired
    IReaderService readerService;

    @Test
    public void test(){
        Readers readers = new Readers();
        readers.setAddress("guangzhou");
        readers.setIdCard("231");
        readers.setPassword("5488456");
        readers.setReaderCode("2");
        readers.setReaderName("xiong");
        readers.setPhone("13587952114");
        System.out.println(readerService.insertReader(readers));
    }

    @Test
    public void test2(){
        Readers readers = new Readers();
        readers.setIdCard("545");
        readers.setPassword("4548");
        readers.setReaderCode("3");
        readers.setReaderName("jun");
        readers.setPhone("13587515484");
        System.out.println(readerService.updateReaderById(2,readers));
    }


}
