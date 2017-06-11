package com.gb.util;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/6/10.
 */
public class Query {
    private ArrayList<String> id2nameList;
    private TreeMap<String, String> id2allTree;

    public Query() {
        initCollection();
//        System.out.println(id2nameList + "\n" + id2nameList.size());
//        System.out.println((id2allTree) + "\n" + id2allTree.size());
    }


    private void initCollection() {
        id2nameList = new ArrayList<>();
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
                id2nameList.add(line);
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
    public boolean isIdExit(int id) {
        String idStr = String.format("0x%08x", id);
        for (String str : id2nameList) {
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
    public int getIdByName(String name) {
        for (String str : id2nameList) {
            if (str.matches(".*=" + name)) {
                String numStr = str.substring(2);
                return Integer.parseInt(numStr.split("=")[0], 16);
            }
        }
        return 0;
    }

    public int getStationIdByName(String name) {
        for (String str : id2nameList) {
            if (str.matches(".*0000=" + name)) {
                String numStr = str.substring(2);
                return Integer.parseInt(numStr.split("=")[0], 16);
            }
        }
        return 0;
    }
    /**
     * @param name 传入要查询的名字
     * @return 0表示没有找到, 其他数字代表具体id
     */
    private ArrayList<String> getIdsByName(String name) {
        ArrayList<String> idList = new ArrayList<>();
        for (String line : id2nameList) {
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
    public ArrayList<String> getInfosByName(String name) {
        ArrayList<String> idList = getIdsByName(name);
        ArrayList<String> infoList = new ArrayList<>();
//        String idStr = String.format("0x%08x", id);
        for (String idStr : idList) {
            infoList.add(id2allTree.get(idStr));
        }
        return infoList;
    }

    public String getInfoById(int id) {
        String idStr = String.format("0x%08x", id);
        return id2allTree.get(idStr);

    }

    public String getNameById(int id) {
        String idStr = String.format("0x%08x", id);
        for (String str : id2nameList) {
            if (str.matches(idStr + "=.*")) {
                return str.split("=")[1];
            }
        }
        return "";
    }
    public ArrayList<String> getShopInfosByStationId(int id, String shopType) {
        String idStr = String.format("0x%08x", id);
        idStr = idStr.substring(0, idStr.length() - 4);
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> infosList = new ArrayList<>();
        ArrayList<String> shopInfosList = new ArrayList<>();
        //获得匹配商店的id值
        for (String str : id2nameList) {
            if (str.matches(idStr + shopType + "([0][^0]|[^0][0]).*")) {
                idList.add(str.split("=")[0]);
            }
        }
        for (String idString : idList) {
            shopInfosList.add(id2allTree.get(idString));
        }

        return shopInfosList;
    }

    public ArrayList<String> getInfosMatchesId(String regexId) {
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> infoList = new ArrayList<>();
        for (String str : id2nameList) {
            if (str.matches(regexId + "=.*")) {
                idList.add(str.split("=")[0]);
            }
        }
        for (String idStr : idList) {
            infoList.add(id2allTree.get(idStr));
        }
        return infoList;
    }

}
