package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class EmployQuality {
    private Integer id;

    private String admcode;

    private String year;

    private BigDecimal employratefirst;

    private BigDecimal coupartemployrate;

    private BigDecimal sixmonthsteadrate;

    private BigDecimal firstemploymonincome;

    private BigDecimal venturerate;

    private BigDecimal stateown;

    private BigDecimal privateown;

    private BigDecimal foreignown;

    private BigDecimal one;

    private BigDecimal two;

    private BigDecimal three;

    private Integer soldier;

    private BigDecimal collegeentance;

    private BigDecimal couterpart;

    private BigDecimal oneyearinner;

    private BigDecimal oneyearouter;

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

    public BigDecimal getEmployratefirst() {
        return employratefirst;
    }

    public void setEmployratefirst(BigDecimal employratefirst) {
        this.employratefirst = employratefirst;
    }

    public BigDecimal getCoupartemployrate() {
        return coupartemployrate;
    }

    public void setCoupartemployrate(BigDecimal coupartemployrate) {
        this.coupartemployrate = coupartemployrate;
    }

    public BigDecimal getSixmonthsteadrate() {
        return sixmonthsteadrate;
    }

    public void setSixmonthsteadrate(BigDecimal sixmonthsteadrate) {
        this.sixmonthsteadrate = sixmonthsteadrate;
    }

    public BigDecimal getFirstemploymonincome() {
        return firstemploymonincome;
    }

    public void setFirstemploymonincome(BigDecimal firstemploymonincome) {
        this.firstemploymonincome = firstemploymonincome;
    }

    public BigDecimal getVenturerate() {
        return venturerate;
    }

    public void setVenturerate(BigDecimal venturerate) {
        this.venturerate = venturerate;
    }

    public BigDecimal getStateown() {
        return stateown;
    }

    public void setStateown(BigDecimal stateown) {
        this.stateown = stateown;
    }

    public BigDecimal getPrivateown() {
        return privateown;
    }

    public void setPrivateown(BigDecimal privateown) {
        this.privateown = privateown;
    }

    public BigDecimal getForeignown() {
        return foreignown;
    }

    public void setForeignown(BigDecimal foreignown) {
        this.foreignown = foreignown;
    }

    public BigDecimal getOne() {
        return one;
    }

    public void setOne(BigDecimal one) {
        this.one = one;
    }

    public BigDecimal getTwo() {
        return two;
    }

    public void setTwo(BigDecimal two) {
        this.two = two;
    }

    public BigDecimal getThree() {
        return three;
    }

    public void setThree(BigDecimal three) {
        this.three = three;
    }

    public Integer getSoldier() {
        return soldier;
    }

    public void setSoldier(Integer soldier) {
        this.soldier = soldier;
    }

    public BigDecimal getCollegeentance() {
        return collegeentance;
    }

    public void setCollegeentance(BigDecimal collegeentance) {
        this.collegeentance = collegeentance;
    }

    public BigDecimal getCouterpart() {
        return couterpart;
    }

    public void setCouterpart(BigDecimal couterpart) {
        this.couterpart = couterpart;
    }

    public BigDecimal getOneyearinner() {
        return oneyearinner;
    }

    public void setOneyearinner(BigDecimal oneyearinner) {
        this.oneyearinner = oneyearinner;
    }

    public BigDecimal getOneyearouter() {
        return oneyearouter;
    }

    public void setOneyearouter(BigDecimal oneyearouter) {
        this.oneyearouter = oneyearouter;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}