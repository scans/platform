package com.xingchengedu.platform.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xingchengedu.platform.dao.ProvinceScoreDao;
import com.xingchengedu.platform.dataobject.ProvinceScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chencheng on 2018/10/20.
 */
@Component
public class ProvinceScorePipeline implements Pipeline {

    @Autowired
    private ProvinceScoreDao provinceScoreDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String realRs = resultItems.get("rs");
        Pattern p = Pattern.compile("fun\\((.*)\\);", Pattern.DOTALL);
        Matcher matcher = p.matcher(realRs);
        boolean f = matcher.matches();
        if (f) {
            JSONObject jsonObject = JSON.parseObject(matcher.group(1));
            JSONArray data = jsonObject.getJSONArray("school");
            List<ProvinceScore> list = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                list.add(covert(data.getJSONObject(i), resultItems.getRequest().getUrl() + "_" + i));
            }
            provinceScoreDao.saveAll(list);
        } else {
            System.out.println("返回结果异常，" + task.getUUID());
        }
    }

    private ProvinceScore covert(JSONObject item, String bizId) {
        ProvinceScore score = new ProvinceScore();
        score.setBizId(bizId);
        score.setSchoolId(item.getString("schoolid"));
        score.setSchoolName(item.getString("schoolname"));
        score.setLocalProvince(item.getString("localprovince"));
        score.setProvince(item.getString("province"));
        score.setStudentType(item.getString("studenttype"));
        score.setYear(item.getString("year"));
        score.setBatch(item.getString("batch"));
        score.setVar(item.getString("var"));
        score.setVarScore(item.getString("var_score"));
        score.setMax(item.getString("max"));
        score.setMin(item.getString("min"));
        score.setNum(item.getString("num"));
        score.setFencha(item.getString("fencha"));
        score.setProvinceScore(item.getString("provincescore"));
        score.setUrl(item.getString("url"));
        return score;
    }
}
