package edu.uestc.lib.MSStudio.collecting.model;

public class SchoolInfo {
    private String admcode;

    private String area;

    private String schoolname;

    private String schooladdr;

    private String telenumber;

    private String runcode;

    public String getAdmcode() {
        return admcode;
    }

    public void setAdmcode(String admcode) {
        this.admcode = admcode == null ? null : admcode.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getSchooladdr() {
        return schooladdr;
    }

    public void setSchooladdr(String schooladdr) {
        this.schooladdr = schooladdr == null ? null : schooladdr.trim();
    }

    public String getTelenumber() {
        return telenumber;
    }

    public void setTelenumber(String telenumber) {
        this.telenumber = telenumber == null ? null : telenumber.trim();
    }

    public String getRuncode() {
        return runcode;
    }

    public void setRuncode(String runcode) {
        this.runcode = runcode == null ? null : runcode.trim();
    }
}