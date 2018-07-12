package com.chr.entity;

public class Products {
    private String id;
    private String name;
    private Double price;
    private String description;
    private String proAddr;
    private String pinyin;

    public Products() {
    }

    public Products(String id, String name, Double price, String description, String proAddr, String pinyin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.proAddr = proAddr;
        this.pinyin = pinyin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProAddr() {
        return proAddr;
    }

    public void setProAddr(String proAddr) {
        this.proAddr = proAddr;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", proAddr='" + proAddr + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
