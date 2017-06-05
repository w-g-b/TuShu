package com.gb.util;

public class AllocationId {
	public static final int LINE_TYPE = 0;
	public static final int STATION_PREFIX = 0xff000000;
	public static final int SHOPTYPE_PREFIX = 0xff000000;
	public static final int SHOPNAME_PREFIX = 0xff000000;

	public static int newId(int idPrefix) {
		int id = 0;
		if (idPrefix == LINE_TYPE) {
			id = newLineId();
		} else if ((idPrefix & SHOPNAME_PREFIX) != 0) {
			id = newShowNameId(id);
		} else if ((idPrefix & SHOPTYPE_PREFIX) != 0) {
			id = newShowTypeId(id);
		} else if ((idPrefix & STATION_PREFIX) != 0) {
			id = newStationId(idPrefix);
		}
		return id;
	}

	private static int newLineId() {
		int id=1;
		while(Query.isIdExist(id<<24)){
			id++;
		}

		return id<<24;
	}

	private static int newStationId(int idPrefix) {
		return 0x01000000;
	}

	private static int newShowTypeId(int idPrefix) {
		return 0x01000000;
	}

	private static int newShowNameId(int idPrefix) {
		return 0x01000000;
	}

}
