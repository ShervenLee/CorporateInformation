package cn.xdf.query;

public class StudyAbroadQuery {
    private int nschoolid;
    private String month,coursecode,coursename;
    private int predict;

    public int getNschoolid() {
        return nschoolid;
    }

    public void setNschoolid(int nschoolid) {
        this.nschoolid = nschoolid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getPredict() {
        return predict;
    }

    public void setPredict(int predict) {
        this.predict = predict;
    }
}
