package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class CounpaSupply {
    private Integer id;

    private String admcode;

    private String year;

    private Integer helpobject;

    private Integer poverreductarget;

    private BigDecimal fund;

    private Integer servicenum;

    private String skill;

    private String project;

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

    public Integer getHelpobject() {
        return helpobject;
    }

    public void setHelpobject(Integer helpobject) {
        this.helpobject = helpobject;
    }

    public Integer getPoverreductarget() {
        return poverreductarget;
    }

    public void setPoverreductarget(Integer poverreductarget) {
        this.poverreductarget = poverreductarget;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public Integer getServicenum() {
        return servicenum;
    }

    public void setServicenum(Integer servicenum) {
        this.servicenum = servicenum;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}