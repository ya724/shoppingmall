package com.dream;

public class CreditApply {
    private String Serialno;
    private String name;
    private String VouchType;
    private double Sum;
    public CreditApply(String Serialno,String name,String VouchType,double Sum){
        this.Serialno=Serialno;
        this.name=name;
        this.VouchType=VouchType;
        this.Sum=Sum;
    }

    public String getSerialno() {
        return Serialno;
    }

    public void setSerialno(String serialno) {
        Serialno = serialno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVouchType() {
        return VouchType;
    }

    public void setVouchType(String vouchType) {
        VouchType = vouchType;
    }

    public double getSum() {
        return Sum;
    }

    public void setSum(double sum) {
        Sum = sum;
    }

}
