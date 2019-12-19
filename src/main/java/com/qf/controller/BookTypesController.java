package com.qf.controller;

import com.qf.service.IBookTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookTypesController")
public class BookTypesController {
    @Autowired
    private IBookTypesService bookTypesService;



}
