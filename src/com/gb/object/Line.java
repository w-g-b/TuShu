package com.gb.object;

import com.gb.util.AllocationId;
import com.gb.util.Query;

public class Line {
    private int id;
    private String name;
    private int firstStationId;
    private int finallyStationId;
    private String firstStationName;
    private String finallStationName;

    //	public Line(){
//		this.id=AllocationId.newId(AllocationId.LINE_TYPE);
//	}
    public Line(String name, int firstStationId, int finallyStationId) {
        this.name = name;
        Query query = new Query();
        this.firstStationId = firstStationId;
        this.firstStationName = query.getNameById(firstStationId);
        this.finallyStationId = finallyStationId;
        this.finallStationName = query.getNameById(finallyStationId);
//        this.finallStation = new Station(new Query().getInfoById(finallyStationId));
        this.id = AllocationId.newId(AllocationId.LINE_TYPE);
    }

    public Line(String info) {
        String str[] = info.split("[ ]+");
        this.id = Integer.parseInt(str[0].substring(2), 16);
        this.name = str[1];
        Query query = new Query();
        this.firstStationId = Integer.parseInt(str[2].substring(2), 16);
        this.firstStationName = query.getNameById(firstStationId);
        this.finallyStationId = Integer.parseInt(str[3].substring(2), 16);
        this.finallStationName = query.getNameById(finallyStationId);

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

    @Override
    public String toString() {
        return name;
    }

    public String toShow() {
        return "线路名:" + name + "\n" + "起始站:" + firstStationName + "\n终点站:" + finallStationName+"\n\n\n";

    }


}
