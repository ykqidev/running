package com.proj.code.collection.treemap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<Province, ArrayList<City>> treeMap = new TreeMap<>();

        ArrayList<City> arrayList1 = new ArrayList<>();
        arrayList1.add(new City(1,"北京市"));

        ArrayList<City> arrayList2 = new ArrayList<>();
        arrayList2.add(new City(1,"海口市"));
        arrayList2.add(new City(2,"三亚市"));

        ArrayList<City> arrayList3 = new ArrayList<>();
        arrayList3.add(new City(1,"天津市"));

        treeMap.put(new Province(1,"北京市"),arrayList1);
        treeMap.put(new Province(2,"海南省"),arrayList2);
        treeMap.put(new Province(3,"天津市"),arrayList3);


        Set<Map.Entry<Province, ArrayList<City>>> entries = treeMap.entrySet();
        for (Map.Entry<Province, ArrayList<City>> entry : entries) {
            System.out.println(entry.getKey().toString());
            ArrayList<City> cityArrayList = entry.getValue();
            cityArrayList.forEach(city -> {
                System.out.println("\t" + city.toString());
            });
        }

    }

}
