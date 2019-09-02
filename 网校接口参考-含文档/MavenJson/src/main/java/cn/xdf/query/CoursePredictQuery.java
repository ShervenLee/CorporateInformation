package cn.xdf.query;

public class CoursePredictQuery {
    private int nschoolid;
    private String coursecode;
    private int predictmonth;
    private int birthday;
    private int gender;
    private int begainmonth;
    private int endmonth;
    private int nlesson;
    private int nnormalcount;
    private int bvip;
    private int bIsResideClass;
    private String leaf1;
    private String leaf3;
    private int english;
    private int steplevel;
    private int Enrollmonth;
    private String sstudentcode;
    private String sAreaCode;
    private int sclasstime;
    private int bvalid;

    public int getNschoolid() {
        return nschoolid;
    }

    public void setNschoolid(int nschoolid) {
        this.nschoolid = nschoolid;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public int getPredictmonth() {
        return predictmonth;
    }

    public void setPredictmonth(int predictmonth) {
        this.predictmonth = predictmonth;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getBegainmonth() {
        return begainmonth;
    }

    public void setBegainmonth(int begainmonth) {
        this.begainmonth = begainmonth;
    }

    public int getEndmonth() {
        return endmonth;
    }

    public void setEndmonth(int endmonth) {
        this.endmonth = endmonth;
    }

    public int getNlesson() {
        return nlesson;
    }

    public void setNlesson(int nlesson) {
        this.nlesson = nlesson;
    }

    public int getNnormalcount() {
        return nnormalcount;
    }

    public void setNnormalcount(int nnormalcount) {
        this.nnormalcount = nnormalcount;
    }

    public int getBvip() {
        return bvip;
    }

    public void setBvip(int bvip) {
        this.bvip = bvip;
    }

    public int getbIsResideClass() {
        return bIsResideClass;
    }

    public void setbIsResideClass(int bIsResideClass) {
        this.bIsResideClass = bIsResideClass;
    }

    public String getLeaf1() {
        return leaf1;
    }

    public void setLeaf1(String leaf1) {
        this.leaf1 = leaf1;
    }

    public String getLeaf3() {
        return leaf3;
    }

    public void setLeaf3(String leaf3) {
        this.leaf3 = leaf3;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getSteplevel() {
        return steplevel;
    }

    public void setSteplevel(int steplevel) {
        this.steplevel = steplevel;
    }

    public int getEnrollmonth() {
        return Enrollmonth;
    }

    public void setEnrollmonth(int enrollmonth) {
        Enrollmonth = enrollmonth;
    }

    public String getSstudentcode() {
        return sstudentcode;
    }

    public void setSstudentcode(String sstudentcode) {
        this.sstudentcode = sstudentcode;
    }

    public String getsAreaCode() {
        return sAreaCode;
    }

    public void setsAreaCode(String sAreaCode) {
        this.sAreaCode = sAreaCode;
    }

    public int getSclasstime() {
        return sclasstime;
    }

    public void setSclasstime(int sclasstime) {
        this.sclasstime = sclasstime;
    }

    public int getBvalid() {
        return bvalid;
    }

    public void setBvalid(int bvalid) {
        this.bvalid = bvalid;
    }

    @Override
    public String toString() {
        return "CoursePredictQuery{" +
                "nschoolid=" + nschoolid +
                ", coursecode='" + coursecode + '\'' +
                ", predictmonth=" + predictmonth +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", begainmonth=" + begainmonth +
                ", endmonth=" + endmonth +
                ", nlesson=" + nlesson +
                ", nnormalcount=" + nnormalcount +
                ", bvip=" + bvip +
                ", bIsResideClass=" + bIsResideClass +
                ", leaf1='" + leaf1 + '\'' +
                ", leaf3='" + leaf3 + '\'' +
                ", english=" + english +
                ", steplevel=" + steplevel +
                ", Enrollmonth=" + Enrollmonth +
                ", sstudentcode='" + sstudentcode + '\'' +
                ", sAreaCode='" + sAreaCode + '\'' +
                ", sclasstime=" + sclasstime +
                ", bvalid=" + bvalid +
                '}';
    }
}
