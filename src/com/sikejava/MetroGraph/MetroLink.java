package com.sikejava.MetroGraph;

/********************************************************************************
 * MetroGraph -- 
 * @version 2017/06/12 20:39
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/**
 * 地铁路径类。
 * 该类表示两个站点之间的行车路径。
 * 路径是双向的，如果有A->B，一定有一条B->A。
 */
public class MetroLink {


    /**
     * 构造函数。
     *
     * @param line 所属线路。
     * @param from 来源站点。
     * @param to   目标站点。
     * @throws ArgumentNullException 如果from或to为空引用，则抛出该异常。
     */
    public MetroLink(MetroLine line, MetroNode from, MetroNode to) throws ArgumentNullException {
        if (line == null) throw new ArgumentNullException("line");
        if (from == null) throw new ArgumentNullException("from");
        if (to == null) throw new ArgumentNullException("to");

        mLine = line;
        mFrom = from;
        mTo = to;
    }

    private MetroNode mFrom;
    private MetroNode mTo;
    private MetroLine mLine;
    private float mWeight;
    private int mFlag;

    public MetroLink(MetroNode from, MetroNode to, MetroLine line, float weight, int flag) throws ArgumentNullException {
        if (line == null) throw new ArgumentNullException("line");
        if (from == null) throw new ArgumentNullException("from");
        if (to == null) throw new ArgumentNullException("to");
        mFrom = from;
        mTo = to;
        mLine = line;
        mWeight = weight;
        mFlag = flag;
    }

    public MetroNode getFrom() {
        return mFrom;
    }

    public void setFrom(MetroNode from) {
        mFrom = from;
    }

    public MetroNode getTo() {
        return mTo;
    }

    public void setTo(MetroNode to) {
        mTo = to;
    }

    public MetroLine getLine() {
        return mLine;
    }

    public void setLine(MetroLine line) {
        mLine = line;
    }

    public float getWeight() {
        return mWeight;
    }

    public void setWeight(float weight) {
        mWeight = weight;
    }

    public int getFlag() {
        return mFlag;
    }

    public void setFlag(int flag) {
        mFlag = flag;
    }

    /**
     * 返回当前对象的字符串表示。
     *
     * @return String
     */
    public String ToString() {
        return String.format("%s:%s->%s", this.mLine.getName(), this.mFrom.getName(), this.mTo.getName());
    }


}
