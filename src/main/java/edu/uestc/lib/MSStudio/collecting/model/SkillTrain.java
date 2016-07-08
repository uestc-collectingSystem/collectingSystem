package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class SkillTrain {
    private Integer id;

    private String admcode;

    private String year;

    private Integer localfoster;

    private Integer localtrain;

    private Integer trackproblemnum;

    private String developname;

    private BigDecimal ecnomicsocial;

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

    public Integer getLocalfoster() {
        return localfoster;
    }

    public void setLocalfoster(Integer localfoster) {
        this.localfoster = localfoster;
    }

    public Integer getLocaltrain() {
        return localtrain;
    }

    public void setLocaltrain(Integer localtrain) {
        this.localtrain = localtrain;
    }

    public Integer getTrackproblemnum() {
        return trackproblemnum;
    }

    public void setTrackproblemnum(Integer trackproblemnum) {
        this.trackproblemnum = trackproblemnum;
    }

    public String getDevelopname() {
        return developname;
    }

    public void setDevelopname(String developname) {
        this.developname = developname == null ? null : developname.trim();
    }

    public BigDecimal getEcnomicsocial() {
        return ecnomicsocial;
    }

    public void setEcnomicsocial(BigDecimal ecnomicsocial) {
        this.ecnomicsocial = ecnomicsocial;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}