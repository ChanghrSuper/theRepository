package com.chr.entity;

public class Orders_Product {
    private String id;

    private String snowid;

    private String proid;

    private Integer number;

    private Double allprice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSnowid() {
        return snowid;
    }

    public void setSnowid(String snowid) {
        this.snowid = snowid == null ? null : snowid.trim();
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }
}