package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class SchoolEnterprise {
    private Integer id;

    private String admcode;

    private String year;

    private Integer majornum;

    private Integer coopagreeenterp;

    private Integer coopagreemajor;

    private Integer coopenterpjointeachmajor;

    private Integer coopenterpjointeachteacher;

    private Integer coopenterpjointeachclass;

    private BigDecimal coopenterpfund;

    private BigDecimal coopenterparrivalfund;

    private BigDecimal coopenterpequitworth;

    private Integer enterpbuildreseadevelop;

    private Integer offschoteachertrainbase;

    private BigDecimal prodtrainbaseval;

    private Integer schoenterpcooporderclassnum;

    private Integer schoenterpdevelopcourse;

    private BigDecimal fullenterprac;

    private Integer fullentertime;

    private BigDecimal parttimeclassradio;

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

    public Integer getMajornum() {
        return majornum;
    }

    public void setMajornum(Integer majornum) {
        this.majornum = majornum;
    }

    public Integer getCoopagreeenterp() {
        return coopagreeenterp;
    }

    public void setCoopagreeenterp(Integer coopagreeenterp) {
        this.coopagreeenterp = coopagreeenterp;
    }

    public Integer getCoopagreemajor() {
        return coopagreemajor;
    }

    public void setCoopagreemajor(Integer coopagreemajor) {
        this.coopagreemajor = coopagreemajor;
    }

    public Integer getCoopenterpjointeachmajor() {
        return coopenterpjointeachmajor;
    }

    public void setCoopenterpjointeachmajor(Integer coopenterpjointeachmajor) {
        this.coopenterpjointeachmajor = coopenterpjointeachmajor;
    }

    public Integer getCoopenterpjointeachteacher() {
        return coopenterpjointeachteacher;
    }

    public void setCoopenterpjointeachteacher(Integer coopenterpjointeachteacher) {
        this.coopenterpjointeachteacher = coopenterpjointeachteacher;
    }

    public Integer getCoopenterpjointeachclass() {
        return coopenterpjointeachclass;
    }

    public void setCoopenterpjointeachclass(Integer coopenterpjointeachclass) {
        this.coopenterpjointeachclass = coopenterpjointeachclass;
    }

    public BigDecimal getCoopenterpfund() {
        return coopenterpfund;
    }

    public void setCoopenterpfund(BigDecimal coopenterpfund) {
        this.coopenterpfund = coopenterpfund;
    }

    public BigDecimal getCoopenterparrivalfund() {
        return coopenterparrivalfund;
    }

    public void setCoopenterparrivalfund(BigDecimal coopenterparrivalfund) {
        this.coopenterparrivalfund = coopenterparrivalfund;
    }

    public BigDecimal getCoopenterpequitworth() {
        return coopenterpequitworth;
    }

    public void setCoopenterpequitworth(BigDecimal coopenterpequitworth) {
        this.coopenterpequitworth = coopenterpequitworth;
    }

    public Integer getEnterpbuildreseadevelop() {
        return enterpbuildreseadevelop;
    }

    public void setEnterpbuildreseadevelop(Integer enterpbuildreseadevelop) {
        this.enterpbuildreseadevelop = enterpbuildreseadevelop;
    }

    public Integer getOffschoteachertrainbase() {
        return offschoteachertrainbase;
    }

    public void setOffschoteachertrainbase(Integer offschoteachertrainbase) {
        this.offschoteachertrainbase = offschoteachertrainbase;
    }

    public BigDecimal getProdtrainbaseval() {
        return prodtrainbaseval;
    }

    public void setProdtrainbaseval(BigDecimal prodtrainbaseval) {
        this.prodtrainbaseval = prodtrainbaseval;
    }

    public Integer getSchoenterpcooporderclassnum() {
        return schoenterpcooporderclassnum;
    }

    public void setSchoenterpcooporderclassnum(Integer schoenterpcooporderclassnum) {
        this.schoenterpcooporderclassnum = schoenterpcooporderclassnum;
    }

    public Integer getSchoenterpdevelopcourse() {
        return schoenterpdevelopcourse;
    }

    public void setSchoenterpdevelopcourse(Integer schoenterpdevelopcourse) {
        this.schoenterpdevelopcourse = schoenterpdevelopcourse;
    }

    public BigDecimal getFullenterprac() {
        return fullenterprac;
    }

    public void setFullenterprac(BigDecimal fullenterprac) {
        this.fullenterprac = fullenterprac;
    }

    public Integer getFullentertime() {
        return fullentertime;
    }

    public void setFullentertime(Integer fullentertime) {
        this.fullentertime = fullentertime;
    }

    public BigDecimal getParttimeclassradio() {
        return parttimeclassradio;
    }

    public void setParttimeclassradio(BigDecimal parttimeclassradio) {
        this.parttimeclassradio = parttimeclassradio;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}