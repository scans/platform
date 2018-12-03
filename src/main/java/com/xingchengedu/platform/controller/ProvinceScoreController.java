package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.dao.ProvinceScoreDao;
import com.xingchengedu.platform.dataobject.ProvinceScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器，返回JSON
 * Created by chencheng on 2018/8/26.
 */
@RestController
@RequestMapping(path = "ps")
public class ProvinceScoreController {

    @Autowired
    private ProvinceScoreDao provinceScoreDao;

    @GetMapping(path = "/all")
    public Page<ProvinceScore> queryAll(String score, Integer page) {
        ProvinceScore order = new ProvinceScore();
        order.setProvinceScore(score);
        return provinceScoreDao.findAll(Example.of(order), PageRequest.of(page, 10));
    }
}
