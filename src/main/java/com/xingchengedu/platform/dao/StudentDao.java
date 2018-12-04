package com.xingchengedu.platform.dao;

import com.xingchengedu.platform.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chencheng on 2018/10/16.
 */
public interface StudentDao extends JpaRepository<Student, Long> {
}
