package cn.sherven.query.result;

public class LoyaltyIndexResult {
    private String sstudentcode;
    private String schoolid;
    private int pay_sum;
    private int pay_sount;
    private int pay_sax;

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

    public int getPay_sum() {
        return pay_sum;
    }

    public void setPay_sum(int pay_sum) {
        this.pay_sum = pay_sum;
    }

    public int getPay_sount() {
        return pay_sount;
    }

    public void setPay_sount(int pay_sount) {
        this.pay_sount = pay_sount;
    }

    public int getPay_sax() {
        return pay_sax;
    }

    public void setPay_sax(int pay_sax) {
        this.pay_sax = pay_sax;
    }
}
