package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class SchoolSize {
    private Integer id;

    private String admcode;

    private String year;

    private String schoolrun;

    private String schoollevel;

    private String schoolsubject;

    private BigDecimal area;

    private BigDecimal ownproparea;

    private BigDecimal totalarea;

    private BigDecimal schownconarea;

    private BigDecimal stuarea;

    private BigDecimal teaauxarea;

    private BigDecimal trainarea;

    private BigDecimal psyarea;

    private BigDecimal dormarea;

    private BigDecimal dormperarea;

    private Integer enrollment;

    private Integer annualgraduate;

    private Integer totalstudent;

    private Integer majors;

    private Integer audit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmcode() {
        return admcode;
    }

    public void setAdmcode(String admcode) {
        this.admcode = admcode == null ? null : admcode.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getSchoolrun() {
        return schoolrun;
    }

    public void setSchoolrun(String schoolrun) {
        this.schoolrun = schoolrun == null ? null : schoolrun.trim();
    }

    public String getSchoollevel() {
        return schoollevel;
    }

    public void setSchoollevel(String schoollevel) {
        this.schoollevel = schoollevel == null ? null : schoollevel.trim();
    }

    public String getSchoolsubject() {
        return schoolsubject;
    }

    public void setSchoolsubject(String schoolsubject) {
        this.schoolsubject = schoolsubject == null ? null : schoolsubject.trim();
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getOwnproparea() {
        return ownproparea;
    }

    public void setOwnproparea(BigDecimal ownproparea) {
        this.ownproparea = ownproparea;
    }

    public BigDecimal getTotalarea() {
        return totalarea;
    }

    public void setTotalarea(BigDecimal totalarea) {
        this.totalarea = totalarea;
    }

    public BigDecimal getSchownconarea() {
        return schownconarea;
    }

    public void setSchownconarea(BigDecimal schownconarea) {
        this.schownconarea = schownconarea;
    }

    public BigDecimal getStuarea() {
        return stuarea;
    }

    public void setStuarea(BigDecimal stuarea) {
        this.stuarea = stuarea;
    }

    public BigDecimal getTeaauxarea() {
        return teaauxarea;
    }

    public void setTeaauxarea(BigDecimal teaauxarea) {
        this.teaauxarea = teaauxarea;
    }

    public BigDecimal getTrainarea() {
        return trainarea;
    }

    public void setTrainarea(BigDecimal trainarea) {
        this.trainarea = trainarea;
    }

    public BigDecimal getPsyarea() {
        return psyarea;
    }

    public void setPsyarea(BigDecimal psyarea) {
        this.psyarea = psyarea;
    }

    public BigDecimal getDormarea() {
        return dormarea;
    }

    public void setDormarea(BigDecimal dormarea) {
        this.dormarea = dormarea;
    }

    public BigDecimal getDormperarea() {
        return dormperarea;
    }

    public void setDormperarea(BigDecimal dormperarea) {
        this.dormperarea = dormperarea;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getAnnualgraduate() {
        return annualgraduate;
    }

    public void setAnnualgraduate(Integer annualgraduate) {
        this.annualgraduate = annualgraduate;
    }

    public Integer getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(Integer totalstudent) {
        this.totalstudent = totalstudent;
    }

    public Integer getMajors() {
        return majors;
    }

    public void setMajors(Integer majors) {
        this.majors = majors;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}