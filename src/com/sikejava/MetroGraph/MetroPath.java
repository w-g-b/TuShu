package com.sikejava.MetroGraph;

import java.util.ArrayList;
import java.util.List;

/********************************************************************************
 * MetroGraph --
 *
 * @version 2017/06/12 20:46
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/**
 * 乘车路线。
 * 该类表示从一个站定到另一个站点的乘车路线。例如：南京西路->人民广场->南京东路。
 */
public class MetroPath {


    private List<MetroLink> mLinks = new ArrayList<>();


    public List<MetroLink> getLinks() {
        return mLinks;
    }

    /**
     * 获取换乘次数。
     *
     * @return
     */
    public int Transfers()

    {
        if (mLinks.size() < 2) return 0;

        int count = 0;
        MetroLine line = mLinks.get(0).getLine();
        for (int i = 1; i < mLinks.size(); i++) {
            if (mLinks.get(i).getLine() != line) {
                line = mLinks.get(i).getLine();
                count++;
            }
        }
        return count;

    }

    /**
     * 判断是否包含指定的站点。
     *
     * @param node 目标站点。
     * @return
     * @throws ArgumentNullException 如果node为空引用，则跑出该异常。
     */
    public boolean ContainsNode(MetroNode node) throws ArgumentNullException {
        if (node == null) throw new ArgumentNullException("node");

        for (MetroLink link : mLinks
                ) {
            if (link.getFrom() == node || link.getTo() == node)
                return true;
        }

        return false;
    }

    /**
     * 最佳一条新的Link，并返回一条新的路线。
     *
     * @param link
     * @return
     * @throws ArgumentNullException 如果link为空引用，则跑出该异常。
     */
    public MetroPath Append(MetroLink link) throws ArgumentNullException {
        if (link == null) throw new ArgumentNullException("link");

        MetroPath newPath = new MetroPath();
        newPath.mLinks.addAll(this.mLinks);
        newPath.mLinks.add(link);

        return newPath;
    }

    /**
     * 合并路线。
     *
     * @param path
     * @return
     * @throws ArgumentNullException 如果path为空引用，则跑出该异常。
     */
    public MetroPath Merge(MetroPath path) throws ArgumentNullException {
        if (path == null) throw new ArgumentNullException("path");

        MetroPath newPath = new MetroPath();
        newPath.mLinks.addAll(this.mLinks);
        newPath.mLinks.addAll(path.mLinks);

        return newPath;
    }


}
