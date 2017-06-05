package com.gb.object;

import com.gb.util.AllocationId;

public class Line {
	private int id;
	private String name;
	private int firstStation;
	private int finallyStation;
	public Line(){
		this.id=AllocationId.newId(AllocationId.LINE_TYPE);
	}
	public Line(String name){
		this.name=name;
		this.id=AllocationId.newId(AllocationId.LINE_TYPE);
	}
	public Line(String name,int firstStation,int finallyStation){
		this.name=name;
		this.firstStation=firstStation;
		this.finallyStation=finallyStation;
		this.id=AllocationId.newId(AllocationId.LINE_TYPE);
	}
	public Line(int id,String name,int firstStation,int finallayStation){
		this.id=id;
		this.name=name;
		this.firstStation=firstStation;
		this.finallyStation=finallayStation;
	}
	
	@Override
	public String toString() {
		return  id + " " + name + " " + firstStation + " "
				+ finallyStation;
	}
	public int getId() {
		return id;
	}
	public String idToString(){
		return "0x"+Integer.toHexString(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFirstStation() {
		return firstStation;
	}
	public void setFirstStation(int firstStation) {
		this.firstStation = firstStation;
	}
	public int getFinallyStation() {
		return finallyStation;
	}
	public void setFinallyStation(int finallyStation) {
		this.finallyStation = finallyStation;
	}
	
	
}
