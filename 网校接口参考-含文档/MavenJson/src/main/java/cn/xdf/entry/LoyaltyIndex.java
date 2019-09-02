package cn.xdf.entry;

import java.util.Date;

/**
 * classname LoyaltyIndex
 * Description 忠诚度计算入参
 */

public class LoyaltyIndex {
    private String sstudentcode;
    private int schoolid;
    private int pay_sum;
    private int pay_count;
    private int pay_max;
    private Date created;
    private int result;

    public String getSstudentcode() {
        return sstudentcode;
    }

    public int getPay_sum() {
        return pay_sum;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public int getPay_count() {
        return pay_count;
    }

    public int getPay_max() {
        return pay_max;
    }

    public Date getCreated() {
        return created;
    }

    public int getResult() {
        return result;
    }

    public void setSstudentcode(String sstudentcode) {
        this.sstudentcode = sstudentcode;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public void setPay_sum(int pay_sum) {
        this.pay_sum = pay_sum;
    }

    public void setPay_count(int pay_count) {
        this.pay_count = pay_count;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setPay_max(int pay_max) {

        this.pay_max = pay_max;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
