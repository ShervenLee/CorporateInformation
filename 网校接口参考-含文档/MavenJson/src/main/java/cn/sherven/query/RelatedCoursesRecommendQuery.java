package cn.sherven.query;

public class RelatedCoursesRecommendQuery {
    private String sstudentcode;
    private String schoolid;
    private String CourseCode;

    public String getSstudentcode() {
        return sstudentcode;
    }

    public void setSstudentcode(String sstudentcode) {
        this.sstudentcode = sstudentcode;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }
}
