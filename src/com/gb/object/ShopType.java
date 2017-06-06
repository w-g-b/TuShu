package com.gb.object;

import com.gb.util.AllocationId;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ShopType {
//    public enum Type {grogshop, supermarket, cate}


    private int id;
    private String name;
    private Station station;

    public ShopType(int id, String name, Station station) {
        this.id = id;
        this.name = name;
        this.station = station;
    }

    public ShopType(String name, Station station) {
        this.name=name;
        this.station=station;
        id = AllocationId.newId(station.getId());
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

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
