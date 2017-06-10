package com.gb.object;


import com.gb.util.AllocationId;

public class Station {
    private int id;
    private String name;
    private int lineId;
    private boolean isTransfer;

    //    public Station() {
    //		id= AllocationId.newId();
    //    }
    public Station(String name, int lineId) {
        this.lineId = lineId;
        this.name = name;
        this.id = AllocationId.newId(lineId);
    }

    public Station(String name, int lineId, boolean isTransfer) {
        this.name = name;
        this.lineId = lineId;
        this.isTransfer = isTransfer;
        this.id = AllocationId.newId(lineId);
    }

    public Station(int id, String name, int lineId, boolean isTransfer) {
        this.id = id;
        this.name = name;
        this.lineId = lineId;
        this.isTransfer = isTransfer;
    }

    public Station(String info) {
        String str[] = info.split("[ ]+");
        this.id = Integer.parseInt(str[0].substring(2), 16);
        this.name = str[1];
        this.lineId = Integer.parseInt(str[2].substring(2), 16);
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

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public boolean isTransfer() {
        return isTransfer;
    }

    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
    }
}
