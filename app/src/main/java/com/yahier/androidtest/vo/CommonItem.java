package com.yahier.androidtest.vo;

import java.util.ArrayList;
import java.util.List;

public class CommonItem {
    public String name;
    public int size;
    public int type;

    public static final int typeNormal = 1;
    public static final int typeDivider = 2;

    public static CommonItem getNormal(String name) {
        CommonItem item = new CommonItem();
        item.type = typeNormal;
        item.name = name;
        item.size = 2;
        return item;
    }

    public static CommonItem getNormal(String name,int size) {
        CommonItem item = new CommonItem();
        item.type = typeNormal;
        item.name = name;
        item.size = size;
        return item;
    }

    public static CommonItem getMark(String name) {
        CommonItem item = new CommonItem();
        item.type = typeDivider;
        item.name = name;
        return item;
    }


    public static List<CommonItem> getNormalList(List<String> list) {
        List<CommonItem> listData = new ArrayList<>();
        for (String item : list) {
            listData.add(getNormal(item));
        }
        return listData;
    }


}
