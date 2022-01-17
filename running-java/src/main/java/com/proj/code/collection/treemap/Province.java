package com.proj.code.collection.treemap;

public class Province implements Comparable<Province>{
    private int id;
    private String name;

    public Province() {

    }

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "id: " + this.id + " name: " + this.name;
    }

    @Override
    public int compareTo(Province o) {
        return this.id - o.id;
    }
}
