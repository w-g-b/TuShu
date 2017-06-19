package com.sikejava.MetroGraph;

import java.awt.*;
import java.util.*;

/********************************************************************************
 * MetroGraph
 * @version 2017/06/12 20:26
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/**
 * 地铁线路类。例如：1号线、2号线。
 */

class MetroLine {

    private String mName = "";
    private Color mColor = Color.white;
    private ArrayList<MetroNode> mMetroNodes = new ArrayList<>();
    private HashMap<MetroLine,MetroNode> mTranferSet = new HashMap<>();

    public HashMap<MetroLine, MetroNode> getTranferSet() {
        return mTranferSet;
    }

    public void setTranferSet(HashMap<MetroLine, MetroNode> tranferSet) {
        mTranferSet = tranferSet;
    }

    public ArrayList<MetroNode> getMetroNodes() {
        return mMetroNodes;
    }

    public void setMetroNodes(ArrayList<MetroNode> metroNodes) {
        mMetroNodes = metroNodes;
    }



    MetroLine(String name,Color color) {
        mName = name;
        mColor = color;
    }

    /**
     * 获取线路的名称。
     * @return
     */
    public String getName() {
        return mName;
    }

    /**
     * 设置线路的名称。
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     *  获取线路的颜色。
     * @return
     */
    public Color getColor() {
        return mColor;
    }

    /**
     * 设置线路的颜色。
     * @param color
     */
    public void setColor(Color color) {
        mColor = color;
    }

    /**
     * 返回当前对象的字符串表示。
     * @return
     */
    public String ToString() {
        return this.mName;
    }

}

/**
 * 地铁线路集合类。
 */
class MetroLineCollection extends HashMap<String,MetroLine> {

    protected String GetKeyForItem(MetroLine item){
        return item.getName();
    }

}
