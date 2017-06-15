package com.gb.util;

import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2017/6/10.
 */
public class Query {
    private static Set<String> id2nameSet;
    private static TreeMap<String, String> id2allTree;

    static {
        initCollection();
//        System.out.println(id2nameSet + "\n" + id2nameSet.size());
//        System.out.println((id2allTree) + "\n" + id2allTree.size());
    }


    private static void initCollection() {
        id2nameSet = new TreeSet<>();
        id2allTree = new TreeMap<>();
        File dir = new File("info");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File id2nameFile = new File(dir, "id2name.tb");
        File id2allFile = new File(dir, "id2all.tb");
        BufferedReader br1 = null, br2 = null;
        try {
            br1 = new BufferedReader(new FileReader(id2nameFile));
            br2 = new BufferedReader(new FileReader(id2allFile));
            String line;
            while ((line = br1.readLine()) != null) {
                id2nameSet.add(line);
            }
            while ((line = br2.readLine()) != null) {
                String lineSplit[] = line.split("=");
                id2allTree.put(lineSplit[0], lineSplit[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br1 != null) {
                try {
                    br1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 判断id值是否已经存在
     *
     * @param id 传入id值
     * @return false表示id值不存在，true表示id值已存在
     */
    public static boolean isIdExit(int id) {
        String idStr = String.format("0x%08x", id);
        for (String str : id2nameSet) {
            if (str.matches(idStr + "=.*")) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param name 传入要查询的名字
     * @return 0表示没有找到, 其他数字代表具体id
     */
    public static int getIdByName(String name) {
        for (String str : id2nameSet) {
            if (str.matches(".*=" + name)) {
                String numStr = str.substring(2);
                return Integer.parseInt(numStr.split("=")[0], 16);
            }
        }
        return 0;
    }

    public static int getLineIdByName(String name) {
        for (String str : id2nameSet) {
            if (str.matches("0x.{2}0{6}=" + name)) {
                String numStr = str.substring(2);
                return Integer.parseInt(numStr.split("=")[0], 16);
            }
        }
        return 0;
    }

    public static ArrayList<String> getStationIdsByName(String name) {
        ArrayList<String> stationIds = new ArrayList<>();
        for (String str : id2nameSet) {
            if (str.matches("0x([0][^0]|[^0].).{2}0000=" + name)) {
//                String numStr = str.substring(2);
//                return Integer.parseInt(numStr.split("=")[0], 16);
                stationIds.add(str.split("=")[0]);
            }
        }
        return stationIds;
    }

    public static int getShopIdByStationAndInfo(String stationId, String shopInfo) {
        for (String str : id2nameSet) {
            if (str.matches(stationId.substring(0, 6) + ".*")) {
                String[] info1Split = shopInfo.split(" +");
                String[] info2Split = id2allTree.get(str.substring(0, 10)).split(" +");
                if (info1Split[1].equals(info2Split[1]) &&
                        info1Split[3].equals(info2Split[3]) &&
                        info1Split[4].equals(info2Split[4])) {
                    return Integer.parseInt(str.substring(2, 10), 16);
                }
            }
        }
        return  0;
    }

    public static ArrayList<String> getIdBySameName(String name) {
        ArrayList<String> idList = new ArrayList<>();
        for (String str : id2nameSet) {
            if (str.matches(".*=" + name)) {
                idList.add(str.substring(2, 10));

            }
        }
        return idList;
    }

    public static int getStationIdByName(String name) {
        for (String str : id2nameSet) {
            if (str.matches(".*0000=" + name)) {
                String numStr = str.substring(2);
                return Integer.parseInt(numStr.split("=")[0], 16);
            }
        }
        return 0;
    }
//    public static int getStationIdByName(String name,String regex) {
//        for (String str : id2nameSet) {
//            if (str.matches(".*0000=" + name)) {
//                String numStr = str.substring(2);
//                return Integer.parseInt(numStr.split("=")[0], 16);
//            }
//        }
//        return 0;
//    }

    /**
     * @param name 传入要查询的名字
     * @return 0表示没有找到, 其他数字代表具体id
     */
    private static ArrayList<String> getIdsByName(String name) {
        ArrayList<String> idList = new ArrayList<>();
        for (String line : id2nameSet) {
            if (line.matches(".*=" + name)) {
//                return Integer.parseInt(numStr.split("=")[0], 16);
                idList.add(line.split("=")[0]);
            }
        }
        return idList;
    }

    /**
     * @param name 传入要查询的名字
     * @return null表示没有找到, 其他包含该对象所有的信息
     */
    public static ArrayList<String> getInfosByName(String name) {
        ArrayList<String> idList = getIdsByName(name);
        ArrayList<String> infoList = new ArrayList<>();
//        String idStr = String.format("0x%08x", id);
        for (String idStr : idList) {
            infoList.add(id2allTree.get(idStr));
        }
        return infoList;
    }

    public static ArrayList<String> getShopIdsByName(String name) {
        ArrayList<String> idList = new ArrayList<>();
        for (String line : id2nameSet) {
            if (line.matches(".*([0][^0]|[^0][0])=" + name)) {
//                return Integer.parseInt(numStr.split("=")[0], 16);
                idList.add(line.split("=")[0]);
            }
        }
        return idList;
    }

    public static ArrayList<String> getShopInfosByName(String name) {

        ArrayList<String> idList = getShopIdsByName(name);
        ArrayList<String> infoList = new ArrayList<>();
//        String idStr = String.format("0x%08x", id);
        for (String idStr : idList) {
            infoList.add(id2allTree.get(idStr));
        }
        return infoList;
    }

    public static String getInfoById(int id) {
        String idStr = String.format("0x%08x", id);
        return id2allTree.get(idStr);

    }

    public static String getNameById(int id) {
        String idStr = String.format("0x%08x", id);
        for (String str : id2nameSet) {
            if (str.matches(idStr + "=.*")) {
                return str.split("=")[1];
            }
        }
        return "";
    }


    public static ArrayList<String> getShopInfosByStationId(int id, String shopType) {
        String idStr = String.format("0x%08x", id);
        idStr = idStr.substring(0, idStr.length() - 4);
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> infosList = new ArrayList<>();
        ArrayList<String> shopInfosList = new ArrayList<>();
        //获得匹配商店的id值
        for (String str : id2nameSet) {
            if (str.matches(idStr + shopType + "([0][^0]|[^0][0]).*")) {
                idList.add(str.split("=")[0]);
            }
        }
        for (String idString : idList) {
            shopInfosList.add(id2allTree.get(idString));
        }

        return shopInfosList;
    }

    public static ArrayList<String> getInfosMatchesId(String regexId) {
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> infoList = new ArrayList<>();
        for (String str : id2nameSet) {
            if (str.matches(regexId + "=.*")) {
                idList.add(str.split("=")[0]);
            }
        }
        for (String idStr : idList) {
            infoList.add(id2allTree.get(idStr));
        }
        return infoList;
    }

    public static void modifyInfo(int id, String newInfo) {
        String idStr = String.format("0x%08x", id);
        id2allTree.remove(idStr);
        for (String str : id2nameSet) {
            if (str.matches(idStr + "=.*")) {
                id2nameSet.remove(str);
                break;
            }
        }
        addInfo(newInfo);

//        String[] split = newInfo.split(" ");
//        id2nameSet.add(split[0] + "=" + split[1]);
//        id2allTree.put(split[0], newInfo);
//        File dir = new File("info");
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        File id2nameFile = new File(dir, "id2name.tb");
//        File id2allFile = new File(dir, "id2all.tb");
//        PrintWriter pw1 = null;
//        PrintWriter pw2 = null;
//        try {
//            pw1 = new PrintWriter(new FileWriter(id2nameFile), true);
//            pw2 = new PrintWriter(new FileWriter(id2allFile), true);
//            for (String line : id2nameSet) {
//                pw1.println(line);
//            }
//            Set<String> set = id2allTree.keySet();
//            for (String line : set) {
//                pw2.println(line + "=" + id2allTree.get(line));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (pw1 != null) {
//                pw1.close();
//            }
//            if (pw2 != null) {
//                pw2.close();
//            }
//        }
    }

    public static boolean isLineStation(int lineId, int statinoId) {
        String lindIdPref = String.format("0x%08x", lineId).substring(0, 4);
        String stationIdPref = String.format("0x%08x", statinoId).substring(0, 4);
        return lindIdPref.equals(stationIdPref);
    }

    //修改某站点下的所有的信息
    public static void modifyStationAllInfo(int id, String newInfo) {
        String idStrRegular = String.format("0x%08x", id).substring(0, 6);
        String idPref = newInfo.substring(0, 6);
        Set<String> newId2NameSet = new TreeSet<>();
        TreeMap<String, String> newId2AllTree = new TreeMap<>();
        Iterator<String> it = id2nameSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.matches(idStrRegular + ".{2}([0][^0]|[^0][0]).*")) {
                String newStr = idPref + str.substring(6);
                it.remove();
                newId2NameSet.add(newStr);
                String oldInfo = id2allTree.get(str.substring(0, 10));
                String[] split = oldInfo.split("[ ]+");
                oldInfo = idPref + split[0].substring(6, 10) + " " + split[1] + " " +
                        idPref + split[2].substring(6, 10) + " " + split[3] + " " +
                        split[4] + " " + split[5];
                id2allTree.remove(str.substring(0, 10));
                newId2AllTree.put(newStr.substring(0, 10), oldInfo);
            }
        }
        id2nameSet.addAll(newId2NameSet);
        id2allTree.putAll(newId2AllTree);
        String idStr = String.format("0x%08x", id);
        id2allTree.remove(idStr);
        for (String str : id2nameSet) {
            if (str.matches(idStr + "=.*")) {
                id2nameSet.remove(str);
                break;
            }
        }
        String[] split = newInfo.split(" ");
        id2nameSet.add(split[0] + "=" + split[1]);
        id2allTree.put(split[0], newInfo);
        writeToFile();
    }

    public static void addInfo(String info) {
        String[] split = info.split(" ");
        id2nameSet.add(split[0] + "=" + split[1]);
        id2allTree.put(split[0], info);
        writeToFile();
    }

    public static void deleteInfo(int id, int infoType) {
        //infoType中
        //4表示删线路
        //6表示删站点
        //10表示删店铺
        String idStrRegular = String.format("0x%08x", id).substring(0, infoType);
        Iterator<String> it = id2nameSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.matches(idStrRegular + ".*")) {
                it.remove();
                id2allTree.remove(str.substring(0, 10));
            }
        }
        writeToFile();
    }

    private static void writeToFile() {
        File dir = new File("info");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File id2nameFile = new File(dir, "id2name.tb");
        File id2allFile = new File(dir, "id2all.tb");
        PrintWriter pw1 = null;
        PrintWriter pw2 = null;
        try {
            pw1 = new PrintWriter(new FileWriter(id2nameFile), true);
            pw2 = new PrintWriter(new FileWriter(id2allFile), true);
            for (String line : id2nameSet) {
                pw1.println(line);
            }
            Set<String> set = id2allTree.keySet();
            for (String line : set) {
                pw2.println(line + "=" + id2allTree.get(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw1 != null) {
                pw1.close();
            }
            if (pw2 != null) {
                pw2.close();
            }
        }
    }

}
