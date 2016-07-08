package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class Funds {
    private Integer id;

    private String admcode;

    private String year;

    private BigDecimal centerfund;

    private BigDecimal localfund;

    private BigDecimal debt;

    private BigDecimal loan;

    private BigDecimal appropriation;

    private BigDecimal teacinputradio;

    private BigDecimal teachertrain;

    private BigDecimal teachchange;

    private BigDecimal fundbudget;

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

    public BigDecimal getCenterfund() {
        return centerfund;
    }

    public void setCenterfund(BigDecimal centerfund) {
        this.centerfund = centerfund;
    }

    public BigDecimal getLocalfund() {
        return localfund;
    }

    public void setLocalfund(BigDecimal localfund) {
        this.localfund = localfund;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public BigDecimal getLoan() {
        return loan;
    }

    public void setLoan(BigDecimal loan) {
        this.loan = loan;
    }

    public BigDecimal getAppropriation() {
        return appropriation;
    }

    public void setAppropriation(BigDecimal appropriation) {
        this.appropriation = appropriation;
    }

    public BigDecimal getTeacinputradio() {
        return teacinputradio;
    }

    public void setTeacinputradio(BigDecimal teacinputradio) {
        this.teacinputradio = teacinputradio;
    }

    public BigDecimal getTeachertrain() {
        return teachertrain;
    }

    public void setTeachertrain(BigDecimal teachertrain) {
        this.teachertrain = teachertrain;
    }

    public BigDecimal getTeachchange() {
        return teachchange;
    }

    public void setTeachchange(BigDecimal teachchange) {
        this.teachchange = teachchange;
    }

    public BigDecimal getFundbudget() {
        return fundbudget;
    }

    public void setFundbudget(BigDecimal fundbudget) {
        this.fundbudget = fundbudget;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}