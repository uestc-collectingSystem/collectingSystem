package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class Equitment {
    private Integer id;

    private String admcode;

    private String year;

    private Long totalassertworth;

    private BigDecimal teacequitworth;

    private BigDecimal trainequitworth;

    private BigDecimal yearteacequitworth;

    private BigDecimal yeartrainequitworth;

    private BigDecimal stutracequitworth;

    private BigDecimal stutrainequitworth;

    private BigDecimal trapracworkpe;

    private Integer intrainbase;

    private Integer outtrainbase;

    private Integer libbooks;

    private Integer libbookselec;

    private Integer yearbooks;

    private Integer readseats;

    private BigDecimal stubook;

    private Integer subscribs;

    private Integer elecbooks;

    private Integer elecseats;

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

    public Long getTotalassertworth() {
        return totalassertworth;
    }

    public void setTotalassertworth(Long totalassertworth) {
        this.totalassertworth = totalassertworth;
    }

    public BigDecimal getTeacequitworth() {
        return teacequitworth;
    }

    public void setTeacequitworth(BigDecimal teacequitworth) {
        this.teacequitworth = teacequitworth;
    }

    public BigDecimal getTrainequitworth() {
        return trainequitworth;
    }

    public void setTrainequitworth(BigDecimal trainequitworth) {
        this.trainequitworth = trainequitworth;
    }

    public BigDecimal getYearteacequitworth() {
        return yearteacequitworth;
    }

    public void setYearteacequitworth(BigDecimal yearteacequitworth) {
        this.yearteacequitworth = yearteacequitworth;
    }

    public BigDecimal getYeartrainequitworth() {
        return yeartrainequitworth;
    }

    public void setYeartrainequitworth(BigDecimal yeartrainequitworth) {
        this.yeartrainequitworth = yeartrainequitworth;
    }

    public BigDecimal getStutracequitworth() {
        return stutracequitworth;
    }

    public void setStutracequitworth(BigDecimal stutracequitworth) {
        this.stutracequitworth = stutracequitworth;
    }

    public BigDecimal getStutrainequitworth() {
        return stutrainequitworth;
    }

    public void setStutrainequitworth(BigDecimal stutrainequitworth) {
        this.stutrainequitworth = stutrainequitworth;
    }

    public BigDecimal getTrapracworkpe() {
        return trapracworkpe;
    }

    public void setTrapracworkpe(BigDecimal trapracworkpe) {
        this.trapracworkpe = trapracworkpe;
    }

    public Integer getIntrainbase() {
        return intrainbase;
    }

    public void setIntrainbase(Integer intrainbase) {
        this.intrainbase = intrainbase;
    }

    public Integer getOuttrainbase() {
        return outtrainbase;
    }

    public void setOuttrainbase(Integer outtrainbase) {
        this.outtrainbase = outtrainbase;
    }

    public Integer getLibbooks() {
        return libbooks;
    }

    public void setLibbooks(Integer libbooks) {
        this.libbooks = libbooks;
    }

    public Integer getLibbookselec() {
        return libbookselec;
    }

    public void setLibbookselec(Integer libbookselec) {
        this.libbookselec = libbookselec;
    }

    public Integer getYearbooks() {
        return yearbooks;
    }

    public void setYearbooks(Integer yearbooks) {
        this.yearbooks = yearbooks;
    }

    public Integer getReadseats() {
        return readseats;
    }

    public void setReadseats(Integer readseats) {
        this.readseats = readseats;
    }

    public BigDecimal getStubook() {
        return stubook;
    }

    public void setStubook(BigDecimal stubook) {
        this.stubook = stubook;
    }

    public Integer getSubscribs() {
        return subscribs;
    }

    public void setSubscribs(Integer subscribs) {
        this.subscribs = subscribs;
    }

    public Integer getElecbooks() {
        return elecbooks;
    }

    public void setElecbooks(Integer elecbooks) {
        this.elecbooks = elecbooks;
    }

    public Integer getElecseats() {
        return elecseats;
    }

    public void setElecseats(Integer elecseats) {
        this.elecseats = elecseats;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}