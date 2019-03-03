package com.xingchengedu.platform.dao;

import com.xingchengedu.platform.dataobject.Section;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 一份一段表数据仓库
 * Created by chencheng on 2018/10/16.
 */
public interface SectionDao extends JpaRepository<Section, Long> {
}
