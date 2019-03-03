package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.dao.SpecialtyScoreDao;
import com.xingchengedu.platform.dataobject.SpecialtyScore;
import com.xingchengedu.platform.dataobject.Student;
import com.xingchengedu.platform.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 测试控制器，返回JSON
 * Created by chencheng on 2018/8/26.
 */
@RestController
@RequestMapping(path = "ss")
public class SpecialtyScoreController {

    @Autowired
    private SpecialtyScoreDao specialtyScoreDao;

    @RequestMapping(path = "/query")
    public Result<List<SpecialtyScore>> matchSpecialty(@RequestParam(defaultValue = "") String schoolId, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        SpecialtyScore order = new SpecialtyScore();
        order.setSchoolId(schoolId);
        order.setStudentType(student.getStudentType());

        Result<List<SpecialtyScore>> rs = new Result<>();
        rs.setResultObj(specialtyScoreDao.findAll(Example.of(order)));
        rs.setSuccess(true);
        return rs;
    }
}
