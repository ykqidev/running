package com.proj.code.enumtype;

public enum Status {
    FREE("空闲"), BUSY("忙"), VOCATION("休假"), LEFT("离职");
    public String desc;

    Status() {
    }

    Status(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name() + ":" + desc;
    }
}
