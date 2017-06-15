package com.zopa.quote.model;

/**
 * Created by martofrog on 14/06/17.
 */
public class Quote {

    private String requestedAmount;

    private String rate;

    private String monthlyRepayment;

    private String totRepayment;

    public String getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(String requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(String monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public String getTotRepayment() {
        return totRepayment;
    }

    public void setTotRepayment(String totRepayment) {
        this.totRepayment = totRepayment;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "requestedAmount='" + requestedAmount + '\'' +
                ", rate='" + rate + '\'' +
                ", monthlyRepayment='" + monthlyRepayment + '\'' +
                ", totRepayment='" + totRepayment + '\'' +
                '}';
    }

}
