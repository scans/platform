package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.dao.ProvinceScoreDao;
import com.xingchengedu.platform.dao.SpecialtyScoreDao;
import com.xingchengedu.platform.dataobject.ProvinceScore;
import com.xingchengedu.platform.dataobject.SpecialtyScore;
import com.xingchengedu.platform.dataobject.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(path = "/query")
    public List<SpecialtyScore> matchSpecialty(@RequestParam(defaultValue = "") String schoolId, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        SpecialtyScore order = new SpecialtyScore();
        order.setSchoolId(schoolId);
        order.setStudentType(student.getStudentType());

        return specialtyScoreDao.findAll(Example.of(order));
    }
}
