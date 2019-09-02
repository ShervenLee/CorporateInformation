package cn.xdf.query;

public class UserSimilarityQuery {
    private int nschoolid;
    private String sstudentcode;
    private int courseCount;
    private int dtbirthday;
    private int ngender;
    private boolean badult;
    private String sname;
    private double similarity;

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public int getNschoolid() {
        return nschoolid;
    }

    public void setNschoolid(int nschoolid) {
        this.nschoolid = nschoolid;
    }

    public String getSstudentcode() {
        return sstudentcode;
    }

    public void setSstudentcode(String sstudentcode) {
        this.sstudentcode = sstudentcode;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public int getDtbirthday() {
        return dtbirthday;
    }

    public void setDtbirthday(int dtbirthday) {
        this.dtbirthday = dtbirthday;
    }

    public int getNgender() {
        return ngender;
    }

    public void setNgender(int ngender) {
        this.ngender = ngender;
    }

    public boolean isBadult() {
        return badult;
    }

    public void setBadult(boolean badult) {
        this.badult = badult;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
