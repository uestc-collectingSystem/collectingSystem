package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class Information {
    private Integer id;

    private String admcode;

    private String year;

    private Integer educateinfo;

    private Integer server;

    private Integer networknum;

    private Integer networkmain;

    private BigDecimal videostu;

    private BigDecimal elecbookstu;

    private Integer teaccomputer;

    private BigDecimal teaccompstu;

    private Integer audit;

    private Integer netmediaroom;

    private Integer netclasscount;

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

    public Integer getEducateinfo() {
        return educateinfo;
    }

    public void setEducateinfo(Integer educateinfo) {
        this.educateinfo = educateinfo;
    }

    public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }

    public Integer getNetworknum() {
        return networknum;
    }

    public void setNetworknum(Integer networknum) {
        this.networknum = networknum;
    }

    public Integer getNetworkmain() {
        return networkmain;
    }

    public void setNetworkmain(Integer networkmain) {
        this.networkmain = networkmain;
    }

    public BigDecimal getVideostu() {
        return videostu;
    }

    public void setVideostu(BigDecimal videostu) {
        this.videostu = videostu;
    }

    public BigDecimal getElecbookstu() {
        return elecbookstu;
    }

    public void setElecbookstu(BigDecimal elecbookstu) {
        this.elecbookstu = elecbookstu;
    }

    public Integer getTeaccomputer() {
        return teaccomputer;
    }

    public void setTeaccomputer(Integer teaccomputer) {
        this.teaccomputer = teaccomputer;
    }

    public BigDecimal getTeaccompstu() {
        return teaccompstu;
    }

    public void setTeaccompstu(BigDecimal teaccompstu) {
        this.teaccompstu = teaccompstu;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public Integer getNetmediaroom() {
        return netmediaroom;
    }

    public void setNetmediaroom(Integer netmediaroom) {
        this.netmediaroom = netmediaroom;
    }

    public Integer getNetclasscount() {
        return netclasscount;
    }

    public void setNetclasscount(Integer netclasscount) {
        this.netclasscount = netclasscount;
    }
}