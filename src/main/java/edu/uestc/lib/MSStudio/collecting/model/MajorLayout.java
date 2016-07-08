package edu.uestc.lib.MSStudio.collecting.model;

public class MajorLayout {
    private Integer id;

    private String admcode;

    private String year;

    private Integer oneindu;

    private Integer twoindu;

    private Integer threeindu;

    private Integer localpillar;

    private Integer provincemore;

    private Integer staunikeymajor;

    private Integer newmajor;

    private Integer stopmajor;

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

    public Integer getOneindu() {
        return oneindu;
    }

    public void setOneindu(Integer oneindu) {
        this.oneindu = oneindu;
    }

    public Integer getTwoindu() {
        return twoindu;
    }

    public void setTwoindu(Integer twoindu) {
        this.twoindu = twoindu;
    }

    public Integer getThreeindu() {
        return threeindu;
    }

    public void setThreeindu(Integer threeindu) {
        this.threeindu = threeindu;
    }

    public Integer getLocalpillar() {
        return localpillar;
    }

    public void setLocalpillar(Integer localpillar) {
        this.localpillar = localpillar;
    }

    public Integer getProvincemore() {
        return provincemore;
    }

    public void setProvincemore(Integer provincemore) {
        this.provincemore = provincemore;
    }

    public Integer getStaunikeymajor() {
        return staunikeymajor;
    }

    public void setStaunikeymajor(Integer staunikeymajor) {
        this.staunikeymajor = staunikeymajor;
    }

    public Integer getNewmajor() {
        return newmajor;
    }

    public void setNewmajor(Integer newmajor) {
        this.newmajor = newmajor;
    }

    public Integer getStopmajor() {
        return stopmajor;
    }

    public void setStopmajor(Integer stopmajor) {
        this.stopmajor = stopmajor;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}