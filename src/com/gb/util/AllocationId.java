package com.gb.util;

public class AllocationId {
    public static final int LINE_TYPE = 0;
    public static final int STATION_PREFIX = 0xff000000;
    public static final int SHOPTYPE_PREFIX = 0x00ff0000;
    public static final int SPECIFICSHOP_PREFIX = 0x0000ff00;

    public static int newId(int idPrefix) {
        int id = 0;
        if (idPrefix == LINE_TYPE) {
            id = newLineId();
        } else if ((idPrefix & SPECIFICSHOP_PREFIX) != 0) {
            id = newSpecificShopId(idPrefix);
        } else if ((idPrefix & SHOPTYPE_PREFIX) != 0) {
            id = newShowTypeId(idPrefix);
        } else if ((idPrefix & STATION_PREFIX) != 0) {
            id = newStationId(idPrefix);
        }
        return id;
    }

    private static int newLineId() {
        int id = 1;
        while (Query.isIdExist(id << 24)) {
            id++;
        }
        return id << 24;
    }

    private static int newStationId(int idPrefix) {
        int id = 1;
        while (Query.isIdExist(idPrefix | (id << 16))) {
            id++;
            if (id > 255) {
                System.out.println("数据过大，数据可能会出现错误");
            }
        }
        return idPrefix | (id << 16);
    }

    private static int newShowTypeId(int idPrefix) {

        int id = 1;
        while (Query.isIdExist(idPrefix | (id << 8))) {
            id++;
            if (id > 255) {
                System.out.println("数据过大，数据可能会出现错误");
            }
        }
        return idPrefix | (id << 8);
    }

    private static int newSpecificShopId(int idPrefix) {

        int id = 1;
        while (Query.isIdExist(idPrefix | id)) {
            id++;
            if (id > 255) {
                System.out.println("数据过大，数据可能会出现错误");
            }
        }
        return idPrefix | id;
    }

}
