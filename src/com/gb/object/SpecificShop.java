package com.gb.object;

import com.gb.util.AllocationId;
import com.gb.util.Query;

/**
 * Created by Administrator on 2017/6/6.
 */
public class SpecificShop {
    private int id;
    private String name;
    private int shopTypeId;
    private int distanceToStation;
    private int remarkGrade;
    private String remarkContent;
    private Station station;

    public SpecificShop(int id, String name, int shopTypeId, int distanceToStation, int remarkGrade, String remarkContent) {
        this.id = id;
        this.name = name;
        this.shopTypeId = shopTypeId;
        this.distanceToStation = distanceToStation;
        this.remarkGrade = remarkGrade;
        this.remarkContent = remarkContent;
    }

    public SpecificShop(String name, int shopTypeId, int distanceToStation, int remarkGrade, String remarkContent) {
        this.name = name;
        this.shopTypeId = shopTypeId;
        this.distanceToStation = distanceToStation;
        this.remarkGrade = remarkGrade;
        this.remarkContent = remarkContent;
        this.id = AllocationId.newId(shopTypeId);
    }

    public SpecificShop(String info) {
        String str[] = info.split("[ ]+");
        this.id = Integer.parseInt(str[0].substring(2), 16);
        this.name = str[1];
        this.shopTypeId = Integer.parseInt(str[2].substring(2), 16);
        this.station = new Station(Query.getInfoById(shopTypeId & 0xffff0000));
        this.distanceToStation = Integer.parseInt(str[3]);
        this.remarkGrade = Integer.parseInt(str[4]);
        this.remarkContent = str[5];
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

    public int getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(int shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public int getDistanceToStation() {
        return distanceToStation;
    }

    public void setDistanceToStation(int distanceToStation) {
        this.distanceToStation = distanceToStation;
    }


    public int getRemarkGrade() {
        return remarkGrade;
    }

    public void setRemarkGrade(int remarkGrade) {
        this.remarkGrade = remarkGrade;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public String toShow() {
        return name + "\n" + "距离" + station.getName() + "地铁站:" + distanceToStation + "米\n" + "用户评分:"
                + remarkGrade + "\n" + "精选评价:" + remarkContent + "\n\n\n";

    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getInfo() {
        return String.format("0x%08x", id) + " " + name + " " + String.format("0x%08x", shopTypeId) + " " + distanceToStation + " " + remarkGrade + " " + remarkContent;
    }
}
