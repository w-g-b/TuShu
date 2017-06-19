package com.sikejava.MetroGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/********************************************************************************
 * MetroGraph -- 
 * @version 2017/06/12 20:44
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/**
 * 地铁站点类。例如：南京西路、世纪公园。
 */
public class MetroNode {


    private String mName = "";
    private int mX;
    private int mY;
    private List<MetroLink> mLinks = new ArrayList<>();
    public boolean mIsTransfer = false;
    public int dist = Integer.MAX_VALUE;
    public MetroNode preNode = null;

    MetroNode(String name,int x,int y) {
        mName = name;
        mX = x;
        mY = y;
    }

    /**
     * 获得站点所在的线路
     * @return
     */
    public ArrayList<MetroLine> getLines()
    {
        ArrayList<MetroLine> lines = new ArrayList<>();
        for(MetroLink link : mLinks) {
            if (!lines.contains(link.getLine())) {
                lines.add(link.getLine());
            }
        }
        return lines;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public List<MetroLink> getLinks() {
        return mLinks;
    }

    public void setLinks(List<MetroLink> links) {
        mLinks = links;
    }

    /**
     * 返回当前对象的字符串表示。
     *
     * @return
     */
    public String ToString() {
        return this.getName();
    }


}

/**
 * 地铁站点集合类。
 */
class MetroNodeCollection extends HashMap<String, MetroNode> {

    protected String GetKeyForItem(MetroNode item) {
        return item.getName();
    }

}
