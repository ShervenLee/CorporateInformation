package cn.xdf.query;

public class AssociateCourseQuery {
    private String sstudentcode;
    private  int schoolid;
    private String coursecode ;
    private String relation;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getSstudentcode() {
        return sstudentcode;
    }

    public void setSstudentcode(String sstudentcode) {
        this.sstudentcode = sstudentcode;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }
}
