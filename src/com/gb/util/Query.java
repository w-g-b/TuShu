package com.gb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Query {

    public static File newFile(String fileName) {
        File dir = new File("info");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, fileName);
        return file;
    }

    public static boolean isIdExit(int id) {
        String idStr = String.format("0x%08x", id);
        File id2nameFile = newFile("id2name.tb");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(id2nameFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches(idStr + "=.*")) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    /**
     * @param name 传入要查询的名字
     * @return 0表示没有找到, 其他数字代表具体id
     */
    public static int getIdByName(String name) {
        File id2nameFile = newFile("id2name.tb");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(id2nameFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches(".*=" + name)) {
                    String numStr = line.substring(2);
                    return Integer.parseInt(numStr.split("=")[0], 16);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param name 传入要查询的名字
     * @return null表示没有找到, 其他包含该对象所有的信息
     */
    public static String getInfoByName(String name) {
        File id2allFile = newFile("id2all.tb");
        int id = getIdByName(name);
        String idStr = String.format("0x%08x", id);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(id2allFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches(idStr + "=.*")) {
                    return line.split("=")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param id 传入要查询的名字
     * @return null表示没有找到, 其他包含该对象所有的信息
     */
    public static String getInfoById(int id) {
        String idStr = String.format("0x%08x", id);
        File id2allFile = newFile("id2all.tb");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(id2allFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches(idStr + "=.*")) {
                    return line.split("=")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param name 传入要查询的名字
     * @return 0表示没有找到, 其他数字代表具体id
     */
    public static ArrayList<String> getIdsByName(String name) {
        File id2nameFile = newFile("id2name.tb");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(id2nameFile));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : list) {
            if (line.matches(".*=" + name)) {
                String numStr = line.split("=")[0];
//                return Integer.parseInt(numStr.split("=")[0], 16);
                idList.add(numStr);
            }
        }
        return idList;
    }

    /**
     * @param name 传入要查询的名字
     * @return null表示没有找到, 其他包含该对象所有的信息
     */
    public static ArrayList<String> getInfosByName(String name) {
        File id2allFile = newFile("id2all.tb");
        ArrayList<String> idList = getIdsByName(name);
        ArrayList<String> infoList = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
//        String idStr = String.format("0x%08x", id);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(id2allFile));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
//                if (line.matches(idStr + "=.*")) {
//                    return line.split("=")[1];
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String idStr : idList) {
            for (String line : list) {
                if (line.matches(idStr + "=.*")) {
                    infoList.add(line.split("=")[1]);
                    break;
                }
            }
        }
        return infoList;
    }

    public static ArrayList<String> getInfosByid(int id) {
        return null;
    }
}
