package com.xingchengedu.platform.controller;

import com.xingchengedu.platform.dao.StudentDao;
import com.xingchengedu.platform.dataobject.Student;
import com.xingchengedu.platform.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void save(Student student) {
        studentDao.saveAndFlush(student);
    }

    @RequestMapping(path = "/login")
    public Result<Student> login(String account, String password, HttpSession session) {
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
        //} else {
        //    rs.setSuccess(false);
        //    rs.setErrorContext("账号或密码错误");
        //}

        return rs;
    }

}
