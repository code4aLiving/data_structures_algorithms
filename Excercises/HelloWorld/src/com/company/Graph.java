package com.company;

import java.util.AbstractMap;
import java.util.List;

/**
 * Created by sergio.nunez on 05/01/2017.
 */
public abstract class Graph<T> {

    int nodesCount;

    public Graph(){
        nodesCount = 0;
    }

    public int getNodesCount() {
        return nodesCount;
    }

    public abstract void addEdge(T u, T v, double w);
    public abstract void addEdge(T u, T v);
    public abstract void addDirectedEdge(T u, T v, double w);
    public abstract void addDirectedEdge(T u, T v);
    public abstract double getWeight(T u, T v) throws Exception;
    public abstract List<T> getAdjs(T u);
    public abstract List<AbstractMap.SimpleImmutableEntry<T,Double>> getAdjWeights(T u) throws Exception;
    public abstract boolean containsEdge(T u, T v);

}
