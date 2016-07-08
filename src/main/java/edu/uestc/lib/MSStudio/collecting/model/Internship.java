package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class Internship {
    private Integer id;

    private String admcode;

    private String year;

    private Integer offcampttrainbase;

    private Integer kownduration;

    private Integer postduration;

    private String displaceduration;

    private BigDecimal stupostpartradio;

    private BigDecimal studispartradio;

    private BigDecimal enterpassessdisopt;

    private BigDecimal enterpassessdisgood;

    private BigDecimal enterpassessdisinter;

    private BigDecimal enterpassessdisbad;

    private BigDecimal coopenterpemploystud;

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

    public Integer getOffcampttrainbase() {
        return offcampttrainbase;
    }

    public void setOffcampttrainbase(Integer offcampttrainbase) {
        this.offcampttrainbase = offcampttrainbase;
    }

    public Integer getKownduration() {
        return kownduration;
    }

    public void setKownduration(Integer kownduration) {
        this.kownduration = kownduration;
    }

    public Integer getPostduration() {
        return postduration;
    }

    public void setPostduration(Integer postduration) {
        this.postduration = postduration;
    }

    public String getDisplaceduration() {
        return displaceduration;
    }

    public void setDisplaceduration(String displaceduration) {
        this.displaceduration = displaceduration == null ? null : displaceduration.trim();
    }

    public BigDecimal getStupostpartradio() {
        return stupostpartradio;
    }

    public void setStupostpartradio(BigDecimal stupostpartradio) {
        this.stupostpartradio = stupostpartradio;
    }

    public BigDecimal getStudispartradio() {
        return studispartradio;
    }

    public void setStudispartradio(BigDecimal studispartradio) {
        this.studispartradio = studispartradio;
    }

    public BigDecimal getEnterpassessdisopt() {
        return enterpassessdisopt;
    }

    public void setEnterpassessdisopt(BigDecimal enterpassessdisopt) {
        this.enterpassessdisopt = enterpassessdisopt;
    }

    public BigDecimal getEnterpassessdisgood() {
        return enterpassessdisgood;
    }

    public void setEnterpassessdisgood(BigDecimal enterpassessdisgood) {
        this.enterpassessdisgood = enterpassessdisgood;
    }

    public BigDecimal getEnterpassessdisinter() {
        return enterpassessdisinter;
    }

    public void setEnterpassessdisinter(BigDecimal enterpassessdisinter) {
        this.enterpassessdisinter = enterpassessdisinter;
    }

    public BigDecimal getEnterpassessdisbad() {
        return enterpassessdisbad;
    }

    public void setEnterpassessdisbad(BigDecimal enterpassessdisbad) {
        this.enterpassessdisbad = enterpassessdisbad;
    }

    public BigDecimal getCoopenterpemploystud() {
        return coopenterpemploystud;
    }

    public void setCoopenterpemploystud(BigDecimal coopenterpemploystud) {
        this.coopenterpemploystud = coopenterpemploystud;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}