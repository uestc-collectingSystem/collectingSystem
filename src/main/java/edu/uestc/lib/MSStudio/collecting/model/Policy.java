package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class Policy {
    private Integer id;

    private String admcode;

    private String year;

    private BigDecimal generalhigh;

    private BigDecimal fundinput;

    private BigDecimal teacherstudent;

    private BigDecimal majorteastu;

    private BigDecimal external;

    private String file;

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

    public BigDecimal getGeneralhigh() {
        return generalhigh;
    }

    public void setGeneralhigh(BigDecimal generalhigh) {
        this.generalhigh = generalhigh;
    }

    public BigDecimal getFundinput() {
        return fundinput;
    }

    public void setFundinput(BigDecimal fundinput) {
        this.fundinput = fundinput;
    }

    public BigDecimal getTeacherstudent() {
        return teacherstudent;
    }

    public void setTeacherstudent(BigDecimal teacherstudent) {
        this.teacherstudent = teacherstudent;
    }

    public BigDecimal getMajorteastu() {
        return majorteastu;
    }

    public void setMajorteastu(BigDecimal majorteastu) {
        this.majorteastu = majorteastu;
    }

    public BigDecimal getExternal() {
        return external;
    }

    public void setExternal(BigDecimal external) {
        this.external = external;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }
}