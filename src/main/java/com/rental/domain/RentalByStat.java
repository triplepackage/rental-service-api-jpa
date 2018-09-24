package com.rental.domain;

/**
 * Created by admin on 9/24/18.
 */
public class RentalByStat {
    private String stat;
    private Long   count;

    public String getStat(){return stat;}

    public void setStat(String city){this.stat = stat;}

    public Long getCount() {return count;}

    public void setCount(Long count){ this.count = count;}

    public RentalByStat(String stat, Long count) {
        this.stat = stat;
        this.count  = count;
    }
}
