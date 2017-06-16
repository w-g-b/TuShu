package com.sikejava.util;

import java.io.*;
import java.util.Properties;

public class Query2 {
    private static Properties name2id;
    private static Properties id2name;
    private static Properties id2property;
    private static Properties id2all;
    private static BufferedWriter bw1;
    private static BufferedWriter bw2;
    private static BufferedWriter bw3;
    private static BufferedWriter bw4;

    static {
        File dir = new File("info");
        if (!dir.exists()) {
            dir.mkdir();
        }
//        File name2idFile = new File(dir, "name2id.tb");
        File id2nameFile = new File(dir, "id2name.tb");
        File id2allFile = new File(dir, "id2all.tb");
        File id2propertyFile = new File(dir, "id2property.tb");
        try {
//            BufferedReader br1 = new BufferedReader(new FileReader(name2idFile));
            BufferedReader br2 = new BufferedReader(new FileReader(id2nameFile));
            BufferedReader br3 = new BufferedReader(new FileReader(id2allFile));
            BufferedReader br4 = new BufferedReader(new FileReader(id2propertyFile));
//            bw1 = new BufferedWriter(new FileWriter(name2idFile, true));
            bw2 = new BufferedWriter(new FileWriter(id2nameFile, true));
            bw3 = new BufferedWriter(new FileWriter(id2allFile, true));
            bw4 = new BufferedWriter(new FileWriter(id2propertyFile, true));
            name2id = new Properties();
            id2name = new Properties();
            id2all = new Properties();
            id2property = new Properties();
//            name2id.load(br1);
            id2name.load(br2);
            id2all.load(br3);
            id2property.load(br4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isIdExist(int id) {
        String idString = String.format("0x%08x", id);
        String str = id2name.getProperty(idString, "");
        return !str.isEmpty();
    }

    /**
     * @param name 传入要查询的名字
     * @return 0表示没有找到, 其他数字代表具体id
     */
    public static int getIdByName(String name) {
        String str = name2id.getProperty(name, "");
        str = str.substring(2);
        if (str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str, 16);
    }


    /**
     * @param name 传入要查询的名字
     * @return null表示没有找到, 其他包含该对象所有的信息
     */
    public static String getInfoByName(String name) {
        String str = name2id.getProperty(name, "");
//        str = str.substring(2);
        if (!str.isEmpty()) {
            String idStr = id2all.getProperty(name, "");
            if (!str.isEmpty()) {
                return str;
            }
        }
        return null;
    }

    /**
     * @param id 传入要查询的名字
     * @return null表示没有找到, 其他包含该对象所有的信息
     */
    public static String getInfoById(int id) {
        String idString = String.format("0x%08x", id);
        String str = id2all.getProperty(idString, "");
        if (!str.isEmpty()) {
            return str;
        }
        return null;
    }
}
