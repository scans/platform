package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.spider.CommonEolPageProcessor;
import com.xingchengedu.platform.spider.ProvinceScorePipeline;
import com.xingchengedu.platform.spider.ScheduleFactory;
import com.xingchengedu.platform.spider.SpecialtyScorePipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import javax.annotation.PostConstruct;

/**
 * 爬虫管理
 * Created by chencheng on 2018/10/20.
 */
@RestController
@RequestMapping(path = "spider")
public class SpiderController {
    @Autowired
    private ProvinceScorePipeline provinceScorePipeline;

    @Autowired
    private SpecialtyScorePipeline specialtyScorePipeline;

    private Spider provinceScoreSpider;
    private Spider specialtyScoreSpider;

    @PostConstruct
    private void init() {
        provinceScoreSpider = Spider.create(new CommonEolPageProcessor())
                .setScheduler(ScheduleFactory.provinceScoreScheduler())
                .addPipeline(provinceScorePipeline)
                //开启5个线程抓取
                .thread(10);
        specialtyScoreSpider = Spider.create(new CommonEolPageProcessor())
                .setScheduler(ScheduleFactory.specialtyScoreScheduler())
                .addPipeline(specialtyScorePipeline)
                //开启5个线程抓取
                .thread(20);
    }


    @RequestMapping(path = "/provinceScore/start")
    public void startProvinceScore() {
        //todo 校验数据，如果ok 没必要启动
        provinceScoreSpider.run();
    }

    @RequestMapping(path = "/specialtyScore/start")
    public void startSpecialtyScore() {
        //todo 校验数据，如果ok 没必要启动
        specialtyScoreSpider.run();
    }
}
