package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.dao.StudentDao;
import com.xingchengedu.platform.dataobject.Student;
import com.xingchengedu.platform.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * 用户管理
 * Created by chencheng on 2018/10/20.
 */
@RestController
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(path = "/update")
    public Result save(@RequestBody Student order, HttpSession session) {
        Result rs = new Result(true);
        Student student = (Student) session.getAttribute("user");
        Optional<Student> optional = studentDao.findById(student.getId());

        if (!optional.isPresent()) {
            rs.setSuccess(false);
            return rs;
        }
        student = optional.get();

        if (StringUtils.isNotBlank(order.getYear())) {
            student.setYear(order.getYear());
        }

        if (null != order.getRank()) {
            student.setRank(order.getRank());
        }

        if (null != order.getScore()) {
            student.setScore(order.getScore());
        }

        if (StringUtils.isNotBlank(order.getHighSchool())) {
            student.setHighSchool(order.getHighSchool());
        }

        if (StringUtils.isNotBlank(order.getQq())) {
            student.setQq(order.getQq());
        }

        if (StringUtils.isNotBlank(order.getStudentType())) {
            student.setStudentType(order.getStudentType());
        }

        if (StringUtils.isNotBlank(order.getProvince())) {
            student.setProvince(order.getProvince());
        }

        studentDao.saveAndFlush(student);
        return rs;
    }

    @RequestMapping(path = "/getLoginUser")
    public Result<Student> getLoginUser(HttpSession session) {
        Result<Student> rs = new Result<>(true);
        Student student = (Student) session.getAttribute("user");
        if (null != student) {
            rs.setResultObj(student);
        } else {
            rs.setSuccess(false);
            rs.setErrorContext("请登录");
        }
        return rs;
    }

    @RequestMapping(path = "/login")
    public Result<Student> login(String account, String password, HttpSession session, HttpServletResponse response) {
        Student order = new Student();
        order.setNumber(account);
        order.setPassword(password);

        //Optional<Student> optional = studentDao.findOne(Example.of(order));

        //结果mock
        Student student = new Student();
        student.setId(1L);
        student.setNumber("xcjy_0001");
        student.setPassword("123456");
        student.setHighSchool("四中");
        student.setProvince("四川");
        student.setQq("123");
        student.setScore(588);
        student.setStudentType("理科");
        student.setYear("2017");

        Result<Student> rs = new Result<>();
        //if (optional.isPresent()) {
        session.setAttribute("user", student);
        rs.setResultObj(student);
        rs.setSuccess(true);
        response.addCookie(new Cookie("JSESSIONID", session.getId()));
        //} else {
        //    rs.setSuccess(false);
        //    rs.setErrorContext("账号或密码错误");
        //}

        return rs;
    }

}
