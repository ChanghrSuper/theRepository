package com.chr.entity;

import java.util.List;

public class Result {
    private Integer total;
    private List<Emp> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Emp> getRows() {
        return rows;
    }

    public void setRows(List<Emp> rows) {
        this.rows = rows;
    }
}
