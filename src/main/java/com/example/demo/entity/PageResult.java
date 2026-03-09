package com.example.demo.entity;

import java.util.List;

public class PageResult<T>implements java.io.Serializable {

    private int total;
    private List<T> data;

    public PageResult(int total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() { return total; }
    public List<T> getData() { return data; }
}