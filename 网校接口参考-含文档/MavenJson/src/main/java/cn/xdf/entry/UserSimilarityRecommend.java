package cn.xdf.entry;


/**
 * classname UserSimilarityRecommend
 * Description 相似用户推荐入参
 */
public class UserSimilarityRecommend {
        private int NSCHOOLID;
        private String SSTUDENTCODE;
        private int COURSE_COUNT;
        private String DTBIRTHDAY;
        private int NGENDER;
        private int BADULT;
        private String SNAME;
        private String similarity;

    public int getNSCHOOLID() {
        return NSCHOOLID;
    }

    public String getSSTUDENTCODE() {
        return SSTUDENTCODE;
    }

    public int getCOURSE_COUNT() {
        return COURSE_COUNT;
    }

    public String getDTBIRTHDAY() {
        return DTBIRTHDAY;
    }

    public int getNGENDER() {
        return NGENDER;
    }

    public String getSimilarity() {
        return similarity;
    }

    public int getBADULT() {
        return BADULT;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setNSCHOOLID(int NSCHOOLID) {
        this.NSCHOOLID = NSCHOOLID;
    }

    public void setSSTUDENTCODE(String SSTUDENTCODE) {
        this.SSTUDENTCODE = SSTUDENTCODE;
    }

    public void setCOURSE_COUNT(int COURSE_COUNT) {
        this.COURSE_COUNT = COURSE_COUNT;
    }

    public void setDTBIRTHDAY(String DTBIRTHDAY) {
        this.DTBIRTHDAY = DTBIRTHDAY;
    }

    public void setNGENDER(int NGENDER) {
        this.NGENDER = NGENDER;
    }

    public void setBADULT(int BADULT) {
        this.BADULT = BADULT;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}

