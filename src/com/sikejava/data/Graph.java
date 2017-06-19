package com.sikejava.data;

import java.util.ArrayList;

/********************************************************************************
 * MetroGraph -- 
 * @version 2017/06/18 13:22
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

enum VStatus {
    UNDISCOVERED, DISCOVERED, VISITED
}

class Vertex<Tv> {
    Tv data;
    int inDegree;
    int outDegree;
    VStatus status;
    int dTime, fTime;
    int parent;
    int priority;

    Vertex(Tv d) {
        data = d;inDegree = outDegree = 0;
        dTime = fTime = parent = -1;
        priority = Integer.MAX_VALUE;
        status = VStatus.UNDISCOVERED;
    }
}

class Edge<Te>
{
    Te data;int weight;
    Edge(Te d, int w){
        data = d;
        weight = w;
    } // 构造
}

public class Graph<Tv, Te> {

    private ArrayList<Vertex<Tv>> V;
    private ArrayList<ArrayList<Edge<Te>>> E;
    
    private void reset() {
        for (Vertex<Tv> vertex :
                V) {
            vertex.status = VStatus.UNDISCOVERED;
            vertex.dTime = vertex.fTime = -1;
            vertex.priority = Integer.MAX_VALUE;
            vertex.parent = -1;
        }
    }

    public Graph(int v) {
        V = new ArrayList<>(v);
        E = new ArrayList<>(v);
        for (ArrayList<Edge<Te>> list :
                E) {
            list = new ArrayList<>(v);
        }
    }

    public void setVertex(int index,Tv data) {

        V.set(index,new Vertex<Tv>(data));

    }

    public void setEdge(int i,int j,Te data,int weight) {

        E.get(i).set(j,new Edge(data,weight));

    }

    public boolean exists(int i,int j) {

        return E.get(i).get(j) != null;

    }
    
    
    

}
