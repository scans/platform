package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.dao.SectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一分一段
 * Created by chencheng on 2019/01/08.
 */
@RestController
@RequestMapping(path = "section")
public class SectionController {

    @Autowired
    private SectionDao sectionDao;

}
