package com.gb.object;

import com.gb.util.AllocationId;

/**
 * Created by Administrator on 2017/6/6.
 */
public class SpecificShop {
    private int id;
    private String name;
    private ShopType shopType;
    private int distanceToStation;
    private int starLevel;
    private int remarkGrade;
    private int remarkContent;

    public SpecificShop(int id, String name, ShopType shopType, int distanceToStation, int starLevel, int remarkGrade, int remarkContent) {
        this.id = id;
        this.name = name;
        this.shopType = shopType;
        this.distanceToStation = distanceToStation;
        this.starLevel = starLevel;
        this.remarkGrade = remarkGrade;
        this.remarkContent = remarkContent;
    }

    public SpecificShop(String name, ShopType shopType, int distanceToStation, int starLevel, int remarkGrade, int remarkContent) {
        this.name = name;
        this.shopType = shopType;
        this.distanceToStation = distanceToStation;
        this.starLevel = starLevel;
        this.remarkGrade = remarkGrade;
        this.remarkContent = remarkContent;
        this.id = AllocationId.newId(shopType.getId());
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

    public ShopType getShopType() {
        return shopType;
    }

    public void setShopType(ShopType shopType) {
        this.shopType = shopType;
    }

    public int getDistanceToStation() {
        return distanceToStation;
    }

    public void setDistanceToStation(int distanceToStation) {
        this.distanceToStation = distanceToStation;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public int getRemarkGrade() {
        return remarkGrade;
    }

    public void setRemarkGrade(int remarkGrade) {
        this.remarkGrade = remarkGrade;
    }

    public int getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(int remarkContent) {
        this.remarkContent = remarkContent;
    }
}
