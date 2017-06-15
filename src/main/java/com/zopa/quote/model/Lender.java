package com.zopa.quote.model;

import java.math.BigDecimal;

/**
 * Created by martofrog on 14/06/17.
 */
public class Lender implements Comparable<Lender> {

    private String lenderName;

    private BigDecimal rate;

    private Integer available;

    public Lender() {}

    public Lender(String lenderName, BigDecimal rate, Integer available) {
        this.lenderName = lenderName;
        this.rate = rate;
        this.available = available;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public int compareTo(Lender otherLender) {
        int res = this.getRate().compareTo(otherLender.getRate());
        if (res != 0) {
            return res;
        }

        res = this.getAvailable().compareTo(otherLender.getAvailable());
        if (res != 0) {
            return res;
        }

        return this.getLenderName().compareToIgnoreCase(otherLender.getLenderName());
    }
}
