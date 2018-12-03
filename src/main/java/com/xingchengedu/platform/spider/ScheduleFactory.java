package com.xingchengedu.platform.spider;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

/**
 * Created by chencheng on 2018/10/16.
 */
public class ScheduleFactory {
    public static final Site site = Site.me().setRetryTimes(3).setSleepTime(6000);

    public ScheduleFactory() {
    }

    public static FileCacheQueueScheduler provinceScoreScheduler() {
        String provinceScore = "http://data.api.gkcx.eol.cn/soudaxue/queryProvinceScore.html?messtype=jsonp&size=50&callback=fun&";
        int pageSize = 50;
        int total = 129634;
        return buildScheduler(provinceScore, "queryProvinceScore", total, pageSize);
    }

    public static FileCacheQueueScheduler specialtyScoreScheduler() {
        String api = "http://data.api.gkcx.eol.cn/soudaxue/querySpecialtyScore.html?messtype=jsonp&size=50&callback=fun&";
        int total = 911825;
        int pageSize = 50;
        return buildScheduler(api, "querySpecialtyScore", total, pageSize);
    }

    private static FileCacheQueueScheduler buildScheduler(String api, String simple, int total, int pageSize) {
        FileCacheQueueScheduler fileCacheQueueScheduler = new FileCacheQueueScheduler("/Users/cc/Downloads/scheduler");
        for (int i = 0; i <= (total / pageSize); i++) {
            int finalI = (i + 1);
            String finalUrl = api + "page=" + finalI;
            fileCacheQueueScheduler.push(new Request(finalUrl), new Task() {
                @Override
                public String getUUID() {
                    return simple + "-page-" + finalI;
                }

                @Override
                public Site getSite() {
                    return site;
                }
            });

        }
        return fileCacheQueueScheduler;
    }

}
