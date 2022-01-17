package com.proj.code.enumtype;

public enum Week {
    MONDAY("星期一", "最困的一天"),
    TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private String name;
    private String desc;

    Week(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private Week() {
    }

    @Override
    public String toString() {
        return "Week{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
