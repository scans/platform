package com.xingchengedu.platform.dataobject;

import javax.persistence.*;

/**
 * Created by chencheng on 2018/10/16.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"bizId"})})
public class SpecialtyScore {
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
    private String specialtyName;
    @Column
    private String localProvince;
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
    private String zyid;
    @Column
    private String url;
    @Column
    private String firstRate;
    @Column
    private String firstRateClass;


    public SpecialtyScore() {
    }

    public String getFirstRateClass() {
        return firstRateClass;
    }

    public void setFirstRateClass(String firstRateClass) {
        this.firstRateClass = firstRateClass;
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

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
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

    public String getZyid() {
        return zyid;
    }

    public void setZyid(String zyid) {
        this.zyid = zyid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(String firstRate) {
        this.firstRate = firstRate;
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
}
