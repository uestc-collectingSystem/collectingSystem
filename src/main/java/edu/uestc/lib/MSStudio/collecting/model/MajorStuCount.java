package edu.uestc.lib.MSStudio.collecting.model;

public class MajorStuCount {
    private Integer id;

    private String admcode;

    private String year;

    private String induname;

    private String name;

    private Integer firstgradesum;

    private Integer secgradesum;

    private Integer thirdgradesum;

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

    public String getInduname() {
        return induname;
    }

    public void setInduname(String induname) {
        this.induname = induname == null ? null : induname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFirstgradesum() {
        return firstgradesum;
    }

    public void setFirstgradesum(Integer firstgradesum) {
        this.firstgradesum = firstgradesum;
    }

    public Integer getSecgradesum() {
        return secgradesum;
    }

    public void setSecgradesum(Integer secgradesum) {
        this.secgradesum = secgradesum;
    }

    public Integer getThirdgradesum() {
        return thirdgradesum;
    }

    public void setThirdgradesum(Integer thirdgradesum) {
        this.thirdgradesum = thirdgradesum;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}