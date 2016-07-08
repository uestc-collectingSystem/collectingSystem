package edu.uestc.lib.MSStudio.collecting.model;

import java.math.BigDecimal;

public class SocialService {
    private Integer id;

    private String admcode;

    private String year;

    private Integer trainstaff;

    private Integer trainunabled;

    private Integer trainunemstaff;

    private Integer trainfarmer;

    private Integer trainretiresoldier;

    private BigDecimal skillidentnum;

    private Integer teachserve;

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

    public Integer getTrainstaff() {
        return trainstaff;
    }

    public void setTrainstaff(Integer trainstaff) {
        this.trainstaff = trainstaff;
    }

    public Integer getTrainunabled() {
        return trainunabled;
    }

    public void setTrainunabled(Integer trainunabled) {
        this.trainunabled = trainunabled;
    }

    public Integer getTrainunemstaff() {
        return trainunemstaff;
    }

    public void setTrainunemstaff(Integer trainunemstaff) {
        this.trainunemstaff = trainunemstaff;
    }

    public Integer getTrainfarmer() {
        return trainfarmer;
    }

    public void setTrainfarmer(Integer trainfarmer) {
        this.trainfarmer = trainfarmer;
    }

    public Integer getTrainretiresoldier() {
        return trainretiresoldier;
    }

    public void setTrainretiresoldier(Integer trainretiresoldier) {
        this.trainretiresoldier = trainretiresoldier;
    }

    public BigDecimal getSkillidentnum() {
        return skillidentnum;
    }

    public void setSkillidentnum(BigDecimal skillidentnum) {
        this.skillidentnum = skillidentnum;
    }

    public Integer getTeachserve() {
        return teachserve;
    }

    public void setTeachserve(Integer teachserve) {
        this.teachserve = teachserve;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}