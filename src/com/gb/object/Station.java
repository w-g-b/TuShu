package com.gb.object;


import com.gb.util.AllocationId;

public class Station {
    private int id;
    private String name;
    private Line line;
    private boolean isTransfer;

    //    public Station() {
    //		id= AllocationId.newId();
    //    }
    public Station(String name, Line line) {
        this.line = line;
        this.name = name;
        this.id = AllocationId.newId(line.getId());
    }

    public Station(int id, String name, Line line, boolean isTransfer) {
        this.id = id;
        this.name = name;
        this.line = line;
        this.isTransfer = isTransfer;
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

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public boolean isTransfer() {
        return isTransfer;
    }

    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
    }
}
