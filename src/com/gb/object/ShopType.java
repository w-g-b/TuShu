package com.gb.object;

import com.gb.util.AllocationId;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ShopType {
//    public enum Type {grogshop, supermarket, cate}


    private int id;
    private String name;
    private int stationId;

    public ShopType(int id, String name, int stationId) {
        this.id = id;
        this.name = name;
        this.stationId = stationId;
    }

    public ShopType(String name, int stationId) {
        this.name=name;
        this.stationId =stationId;
        id = AllocationId.newId(stationId);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStation() {
        return stationId;
    }

    public void setStation(int stationId) {
        this.stationId = stationId;
    }
}
