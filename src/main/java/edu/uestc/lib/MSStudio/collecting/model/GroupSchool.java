package edu.uestc.lib.MSStudio.collecting.model;

public class GroupSchool {
    private Integer id;

    private String admcode;

    private String year;

    private Integer leadvocedugroup;

    private Integer joinleadvocedugroupscho;

    private Integer joinleadvocedugroupmajor;

    private Integer joinvocedugroup;

    private Integer joinleadvocedugroupenterp;

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

    public Integer getLeadvocedugroup() {
        return leadvocedugroup;
    }

    public void setLeadvocedugroup(Integer leadvocedugroup) {
        this.leadvocedugroup = leadvocedugroup;
    }

    public Integer getJoinleadvocedugroupscho() {
        return joinleadvocedugroupscho;
    }

    public void setJoinleadvocedugroupscho(Integer joinleadvocedugroupscho) {
        this.joinleadvocedugroupscho = joinleadvocedugroupscho;
    }

    public Integer getJoinleadvocedugroupmajor() {
        return joinleadvocedugroupmajor;
    }

    public void setJoinleadvocedugroupmajor(Integer joinleadvocedugroupmajor) {
        this.joinleadvocedugroupmajor = joinleadvocedugroupmajor;
    }

    public Integer getJoinvocedugroup() {
        return joinvocedugroup;
    }

    public void setJoinvocedugroup(Integer joinvocedugroup) {
        this.joinvocedugroup = joinvocedugroup;
    }

    public Integer getJoinleadvocedugroupenterp() {
        return joinleadvocedugroupenterp;
    }

    public void setJoinleadvocedugroupenterp(Integer joinleadvocedugroupenterp) {
        this.joinleadvocedugroupenterp = joinleadvocedugroupenterp;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}