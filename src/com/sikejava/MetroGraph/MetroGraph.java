package com.sikejava.MetroGraph;


import com.sikejava.data.FileUtil;
import com.sikejava.data.Queue;
import java.util.ArrayList;


/********************************************************************************
 * MetroGraph
 * @version 2017/06/12 20:23
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

public class MetroGraph {


    private MetroLineCollection mLines = new MetroLineCollection();
    private MetroNodeCollection mNodes = new MetroNodeCollection();
    private MetroLine line = null;


    public MetroLineCollection getLines() {
        return mLines;
    }

    public MetroNodeCollection getNodes() {
        return mNodes;
    }

    private void LoadLines() {

        String data = FileUtil.read("info\\g.txt", null);

        String[] lines = data.split("\n");
        MetroLine line;
        for (int i = 0; i < lines.length; ++i) {
            String[] nodes = lines[i].split("-->");
            line = mLines.get(nodes[0]);
            for (int j = 1; j < nodes.length; j++) {
                line.getMetroNodes().add(mNodes.get(nodes[j]));
                if (mNodes.get(nodes[j]).getLinks().size() > 2)
                {
                    mNodes.get(nodes[j]).mIsTransfer = true;
                    for(MetroLine line1 : mNodes.get(nodes[j]).getLines()) {
                        if(line1 != line)
                            line.getTranferSet().put(line1,mNodes.get(nodes[j]));
                    }
                }
            }
        }
    }


    /**
     * 查找直达路线
     * @param startNode
     * @param endNode
     * @param line
     * @return
     */
    public ArrayList<MetroNode> FindDrectPath(MetroNode startNode, MetroNode endNode, MetroLine line) {

        LoadLines();

        int start = 0, end = 0;
        for (int i = 0; i < line.getMetroNodes().size(); ++i) {
            if (line.getMetroNodes().get(i) == startNode)
                start = i;
            if (line.getMetroNodes().get(i) == endNode)
                end = i;
        }

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        ArrayList<MetroNode> path = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            path.add(line.getMetroNodes().get(i));
        }
        return path;
    }

    /**
     * 获取地铁路径的枚举迭代。该属性始终不为空引用。
     *
     * @return
     */
    public ArrayList<MetroLink> Links() {

        ArrayList<MetroLink> links = new ArrayList<>();

        for (MetroNode node :
                mNodes.values()) {
            for (MetroLink link :
                    node.getLinks()) {
                links.add(link);
            }
        }

        return links;
    }

    private void reset() {
        for (MetroNode node :
                mNodes.values()) {
            node.dist = Integer.MAX_VALUE;
            node.preNode = null;
        }
    }

    /**
     * 获取指定两个线路的中转站。
     *
     * @param line1 线路1。
     * @param line2 线路2。
     * @return
     * @throws ArgumentNullException 如果line1或line2为空引用，则抛出该异常。
     */
    public ArrayList<MetroNode> GetTransferNodes(MetroLine line1, MetroLine line2) throws ArgumentNullException {

        if (line1 == null) throw new ArgumentNullException("line1");
        if (line2 == null) throw new ArgumentNullException("line2");
        //if (line1 == line2) return null;

        ArrayList<MetroNode> nodes = new ArrayList<>();

        for (MetroNode node :
                mNodes.values()) {
            if (node.getLinks().size() > 2 && node.getLinks().contains(line1) && node.getLinks().contains(line2)) {
                nodes.add(node);
            }
        }

        return nodes;
    }

    public ArrayList<MetroNode> FindPath(MetroNode startNode, MetroNode endNode) {
        LoadLines();
        reset();
        Queue<MetroNode> queue = new Queue<>();
        queue.enqueue(startNode);
        startNode.dist = 0;
        while (!queue.isEmpty()) {
            MetroNode node = queue.dequeue();
            for (MetroLink link : node.getLinks()) {
                if (link.getTo().dist == Integer.MAX_VALUE) {
                    link.getTo().dist = node.dist + 1;
                    queue.enqueue(link.getTo());
                    link.getTo().preNode = node;
                }
            }
        }
        ArrayList<MetroNode> metroNodes = new ArrayList<>();
        for (MetroNode node : mNodes.values()) {
            if (node == endNode) {
                System.out.print(node.getName() + "-->");
                metroNodes.add(node);
                MetroNode tmpprv = node.preNode;
                while (tmpprv != null) {
                    System.out.print(tmpprv.getName() + "-->");
                    metroNodes.add(tmpprv);
                    tmpprv = tmpprv.preNode;
                }
                System.out.println("distance=" + node.dist);
            }
        }
        return metroNodes;
    }

    public ArrayList<MetroNode> FindMinTransPath(MetroNode startNode,MetroNode endNode) {

        LoadLines();

        ArrayList<ArrayList<MetroNode>> pathLists = new ArrayList<>();
        ArrayList<MetroNode> path = new ArrayList<>();
        if(getSameLine(startNode,endNode) != null)
            return FindDrectPath(startNode,endNode,getSameLine(startNode,endNode));
        else {
            for(MetroLine line : startNode.getLines()) {
                for(MetroLine line1 : endNode.getLines()) {
                    ArrayList<MetroNode> transList = FindTransfer(line,line1);
                    if(transList.size() == 1) {
                        path = FindDrectPath(transList.get(0),endNode,line1);
                        path.addAll(FindDrectPath(startNode,transList.get(0),line));
                        return path;
                    }
                    else if(transList.size() == 2)
                    {
                        path = FindDrectPath(startNode,transList.get(0),line);
                        path.addAll(FindDrectPath(transList.get(0),transList.get(1),this.line));
                        path.addAll(FindDrectPath(transList.get(1),endNode,line1));
                    }
                    else {
                        return FindPath(startNode,endNode);
                    }
                    pathLists.add(path);
                }
            }
        }

        return GetShortestPath(pathLists);
    }

    public ArrayList<MetroNode> FindTransfer(MetroLine start,MetroLine end) {

        ArrayList<MetroNode> metroNodes = new ArrayList<>();

        for(MetroLine line : end.getTranferSet().keySet()) {
            if(line == start)
            {
                metroNodes.add(end.getTranferSet().get(line));
                return metroNodes;
            }
        }

        for(MetroLine line : end.getTranferSet().keySet()) {
            for(MetroLine line1 : line.getTranferSet().keySet())
            {
                if(line1 == start)
                {
                    metroNodes.add(start.getTranferSet().get(line));
                    metroNodes.add(end.getTranferSet().get(line));
                    this.line = line;
                    return metroNodes;
                }
            }
        }
        return metroNodes;
    }

        private ArrayList<MetroNode> GetShortestPath(ArrayList<ArrayList<MetroNode>> pathList) {

        ArrayList<MetroNode> minPath = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (ArrayList<MetroNode> path :
                pathList) {
            if (path.size() < minLength) {
                minLength = path.size();
                minPath = path;
            }
        }
        return minPath;
    }

    private MetroLine getSameLine(MetroNode node1,MetroNode node2) {

        for(MetroLine line1 : node1.getLines()) {
            for(MetroLine line2 : node2.getLines()) {
                if(line1 == line2)
                    return line1;
            }
        }
        return null;
    }
}


