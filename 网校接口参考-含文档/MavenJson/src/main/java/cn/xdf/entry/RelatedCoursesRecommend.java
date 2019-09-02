package cn.xdf.entry;

import java.util.Date;

/**
 * nameclass RelatedCoursesRecommend
 * Description 关联课程推荐入参
 */
public class RelatedCoursesRecommend {
    private String sstudentcode;
    private int schoolid;
    private String Coursecode;
    private Date created;
    private String relation;

    public String getSstudentcode() {
        return sstudentcode;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public String getCoursecode() {
        return Coursecode;
    }

    public Date getCreated() {
        return created;
    }

    public String getRelation() {
        return relation;
    }

    public void setSstudentcode(String sstudentcode) {
        this.sstudentcode = sstudentcode;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public void setCoursecode(String coursecode) {
        Coursecode = coursecode;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
