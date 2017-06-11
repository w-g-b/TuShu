package com.gb.object;

import com.gb.util.AllocationId;
import com.gb.util.Query;

public class Line {
    private int id;
    private String name;
    private int firstStationId;
    private int finallyStationId;
    private String firstStationName;
    private String finallyStationName;

    //	public Line(){
//		this.id=AllocationId.newId(AllocationId.LINE_TYPE);
//	}
    public Line(String name, int firstStationId, int finallyStationId) {
        this.name = name;
        this.firstStationId = firstStationId;
        this.firstStationName = Query.getNameById(firstStationId);
        this.finallyStationId = finallyStationId;
        this.finallyStationName = Query.getNameById(finallyStationId);
//        this.finallStation = new Station(new Query().getInfoById(finallyStationId));
        this.id = AllocationId.newId(AllocationId.LINE_TYPE);
    }

    public Line(String info) {
        String str[] = info.split("[ ]+");
        this.id = Integer.parseInt(str[0].substring(2), 16);
        this.name = str[1];
        this.firstStationId = Integer.parseInt(str[2].substring(2), 16);
        this.firstStationName = Query.getNameById(firstStationId);
        this.finallyStationId = Integer.parseInt(str[3].substring(2), 16);
        this.finallyStationName = Query.getNameById(finallyStationId);

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

    public int getFirstStationId() {
        return firstStationId;
    }

    public void setFirstStationId(int firstStationId) {
        this.firstStationId = firstStationId;
    }

    public int getFinallyStationId() {
        return finallyStationId;
    }

    public void setFinallyStationId(int finallyStationId) {
        this.finallyStationId = finallyStationId;
    }

    public String getFirstStationName() {
        return firstStationName;
    }

    public void setFirstStationName(String firstStationName) {
        this.firstStationName = firstStationName;
    }

    public String getFinallyStationName() {
        return finallyStationName;
    }

    public void setFinallyStationName(String finallyStationName) {
        this.finallyStationName = finallyStationName;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toShow() {
        return "线路名:" + name + "\n" + "起始站:" + firstStationName + "\n终点站:" + finallyStationName +"\n\n\n";

    }


}
