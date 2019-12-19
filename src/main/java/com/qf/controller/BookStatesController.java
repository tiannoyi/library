package com.qf.controller;

import com.qf.service.IBookStatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookStatesController")
public class BookStatesController {
    @Autowired
    private IBookStatesService bookStatesService;


}
