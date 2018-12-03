package com.xingchengedu.platform.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by chencheng on 2018/9/15.
 */
public class CommonEolPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        page.putField("rs", page.getRawText());
    }

    @Override
    public Site getSite() {
        return ScheduleFactory.site;
    }
}
