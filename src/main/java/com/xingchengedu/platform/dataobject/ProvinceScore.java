package com.xingchengedu.platform.dataobject;

import javax.persistence.*;

/**
 * 学校省份分数
 * Created by chencheng on 2018/10/16.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"bizId"})})
public class ProvinceScore {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String bizId;
    @Column
    private String schoolId;
    @Column
    private String schoolName;
    @Column
    private String localProvince;
    @Column
    private String province;
    @Column
    private String studentType;
    @Column
    private String year;
    @Column
    private String batch;
    @Column
    private String var;
    @Column
    private String varScore;
    @Column
    private String max;
    @Column
    private String min;
    @Column
    private String num;
    @Column
    private String fencha;
    @Column
    private String provinceScore;
    @Column
    private String url;


    public ProvinceScore() {
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocalProvince() {
        return localProvince;
    }

    public void setLocalProvince(String localProvince) {
        this.localProvince = localProvince;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getVarScore() {
        return varScore;
    }

    public void setVarScore(String varScore) {
        this.varScore = varScore;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFencha() {
        return fencha;
    }

    public void setFencha(String fencha) {
        this.fencha = fencha;
    }

    public String getProvinceScore() {
        return provinceScore;
    }

    public void setProvinceScore(String provinceScore) {
        this.provinceScore = provinceScore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}