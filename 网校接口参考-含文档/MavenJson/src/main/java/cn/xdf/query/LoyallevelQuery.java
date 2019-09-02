package cn.xdf.query;

import java.util.Date;

public class LoyallevelQuery {

    private String sstudentcode;
    private int schoolid;
    private int pay_sum;
    private int pay_count;
    private int pay_max;
    private int result;

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

    public int getPay_sum() {
        return pay_sum;
    }

    public void setPay_sum(int pay_sum) {
        this.pay_sum = pay_sum;
    }

    public int getPay_count() {
        return pay_count;
    }

    public void setPay_count(int pay_count) {
        this.pay_count = pay_count;
    }

    public int getPay_max() {
        return pay_max;
    }

    public void setPay_max(int pay_max) {
        this.pay_max = pay_max;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LoyallevelQuery{" +
                "sstudentcode='" + sstudentcode + '\'' +
                ", schoolid=" + schoolid +
                ", pay_sum=" + pay_sum +
                ", pay_count=" + pay_count +
                ", pay_max=" + pay_max +
                ", result=" + result +
                '}';
    }
}
