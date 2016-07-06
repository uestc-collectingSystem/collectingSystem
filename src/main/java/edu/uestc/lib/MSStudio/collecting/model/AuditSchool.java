package edu.uestc.lib.MSStudio.collecting.model;

public class AuditSchool {
    private Integer id;

    private String admcode;

    private String auditcode;

    private String schoolname;

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

    public String getAuditcode() {
        return auditcode;
    }

    public void setAuditcode(String auditcode) {
        this.auditcode = auditcode == null ? null : auditcode.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }
}