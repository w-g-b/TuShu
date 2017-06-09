package com.gb.object;

import com.gb.util.AllocationId;

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
}
