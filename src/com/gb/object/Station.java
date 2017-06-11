package com.gb.object;


import com.gb.util.AllocationId;
import com.gb.util.Query;

public class Station {
    private int id;
    private String name;
    private int lineId;
    private Line line;
    private boolean isTransfer;


    public Station(String name, int lineId, boolean isTransfer) {
        this.name = name;
        this.lineId = lineId;
        this.isTransfer = isTransfer;
        this.line = new Line(new Query().getInfoById(lineId));
        this.id = AllocationId.newId(lineId);
    }


    public Station(String info) {
        String str[] = info.split("[ ]+");
        this.id = Integer.parseInt(str[0].substring(2), 16);
        this.name = str[1];
        this.lineId = Integer.parseInt(str[2].substring(2), 16);
        this.line = new Line(new Query().getInfoById(lineId));

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

    @Override
    public String toString() {
        return name;
    }

    public String toShow() {
        return "վ������" + name + "\n" + "��·:" + line.getName() + "\n" + "�Ƿ񻻳�:" + (isTransfer ? "����" : "������"+"\n\n\n");
    }
}
