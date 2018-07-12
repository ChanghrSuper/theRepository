package com.chr.entity;

import java.util.Date;

public class Emp {

    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private Date bir;
    private Dept dept;

    public Emp() {
    }

    public Emp(String id, String name, Double salary, Integer age, Date bir, Dept dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.bir = bir;
        this.dept = dept;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", bir=" + bir +
                ", dept=" + dept +
                '}';
    }
}
