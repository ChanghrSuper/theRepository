package com.chr.entity;

public class MasterSlave {
    private String id;
    private String name;

    public MasterSlave() {
    }

    @Override
    public String toString() {
        return "master_slave{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
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

    public MasterSlave(String id, String name) {

        this.id = id;
        this.name = name;
    }
}
