package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class Structure {
    private Integer id;

    private String admcode;

    private String year;

    private Integer resecondnum;

    private Integer ordhighnum;

    private Integer resecondstunum;

    private Integer resecondentrollnum;

    private Integer ordhighstunum;

    private Integer ordhighentrollnum;

    private BigDecimal highentrollradio;

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

    public Integer getResecondnum() {
        return resecondnum;
    }

    public void setResecondnum(Integer resecondnum) {
        this.resecondnum = resecondnum;
    }

    public Integer getOrdhighnum() {
        return ordhighnum;
    }

    public void setOrdhighnum(Integer ordhighnum) {
        this.ordhighnum = ordhighnum;
    }

    public Integer getResecondstunum() {
        return resecondstunum;
    }

    public void setResecondstunum(Integer resecondstunum) {
        this.resecondstunum = resecondstunum;
    }

    public Integer getResecondentrollnum() {
        return resecondentrollnum;
    }

    public void setResecondentrollnum(Integer resecondentrollnum) {
        this.resecondentrollnum = resecondentrollnum;
    }

    public Integer getOrdhighstunum() {
        return ordhighstunum;
    }

    public void setOrdhighstunum(Integer ordhighstunum) {
        this.ordhighstunum = ordhighstunum;
    }

    public Integer getOrdhighentrollnum() {
        return ordhighentrollnum;
    }

    public void setOrdhighentrollnum(Integer ordhighentrollnum) {
        this.ordhighentrollnum = ordhighentrollnum;
    }

    public BigDecimal getHighentrollradio() {
        return highentrollradio;
    }

    public void setHighentrollradio(BigDecimal highentrollradio) {
        this.highentrollradio = highentrollradio;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}