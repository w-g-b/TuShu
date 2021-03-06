package com.sikejava.object;


import com.sikejava.util.AllocationId;
import com.sikejava.util.Query;

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
        this.line = new Line(Query.getInfoById(lineId));
        this.id = AllocationId.newId(lineId);
    }


    public Station(String info) {
        String str[] = info.split("[ ]+");
        this.id = Integer.parseInt(str[0].substring(2), 16);
        this.name = str[1];
        this.lineId = Integer.parseInt(str[2].substring(2), 16);
        this.line = new Line(Query.getInfoById(lineId));
        this.isTransfer=str[3].equals("true")?true:false;

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

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toShow() {
        return "վ������" + name + "\n" + "��·:" + line.getName() + "\n" + "�Ƿ񻻳�:" + (isTransfer ? "����" : "������"+"\n\n\n");
    }
}
