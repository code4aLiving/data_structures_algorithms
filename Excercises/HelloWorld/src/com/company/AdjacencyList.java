package com.company;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sergio.nunez on 05/01/2017.
 */
public class AdjacencyList<T> extends Graph<T>{
    private HashMap<T,List<SimpleImmutableEntry<T,Double>>> hashMap;

    public AdjacencyList(){
        super();
        hashMap = new HashMap<>();
    }

    @Override
    public void addEdge(T u, T v, double w) {
        addDirectedEdge(u,v,w);
        addDirectedEdge(v,u,w);
    }

    @Override
    public void addEdge(T u, T v) {
        addEdge(u,v,0);
    }

    @Override
    public void addDirectedEdge(T u, T v, double w) {
        if (hashMap.containsKey(u)){
            hashMap.get(u).add(new SimpleImmutableEntry<>(v, w));
        }
        else{
            List<SimpleImmutableEntry<T,Double>> adj = new ArrayList<>();
            adj.add(new SimpleImmutableEntry<>(v, w));
            hashMap.put(u,adj);
        }
    }

    @Override
    public void addDirectedEdge(T u, T v) {
        addDirectedEdge(u,v,0);
    }

    @Override
    public double getWeight(T u, T v) throws Exception {
        if (!hashMap.containsKey(u))
            throw new Exception("The node " + u + " does not exists on the graph");
        if (!hashMap.containsKey(v))
            throw new Exception("The node " + v + " does not exists on the graph");

        for(SimpleImmutableEntry<T,Double> entry : hashMap.get(u)){
            if (entry.getKey() == v)
                return entry.getValue();
        }
        throw new Exception("There's no edge between nodes " + u + " and " + v);
    }

    @Override
    public List<T> getAdjs(T u) {
        List<T> adjs = new ArrayList<>();
        for (SimpleImmutableEntry<T,Double> tuple : hashMap.get(u)){
            adjs.add(tuple.getKey());
        }
        return adjs;
    }

    @Override
    public List<SimpleImmutableEntry<T, Double>> getAdjWeights(T u) throws Exception {
        if (!hashMap.containsKey(u))
            throw new Exception("The node " + u + " does not exists on the graph");
        return hashMap.get(u);
    }

    @Override
    public boolean containsEdge(T u, T v) {
        if (hashMap.containsKey(u) || hashMap.containsKey(v))
            return false;
        List<T> adjs = getAdjs(u);
        if (adjs.contains(v))
            return true;
        return false;
    }
}

