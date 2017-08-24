package algorithms;

import datastructures.GraphNode;

import java.io.*;
import java.util.*;

public class GraphAlgorithms {

    public static HashMap<Integer,HashSet<Integer>> load_undirected_graph(String text)
            throws IOException {

        ByteArrayInputStream inStream = new ByteArrayInputStream(text.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

        int edges = Integer.parseInt(br.readLine().trim());
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            String [] line = br.readLine().split(" ");
            Integer u = Integer.parseInt(line[0]);
            Integer v = Integer.parseInt(line[1]);

            add_edge(u, v, graph);
            add_edge(v, u, graph);
        }
        return graph;
    }

    public static <T> void add_edge(T u, T v, HashMap<T,HashSet<T>> graph){
        if (graph.containsKey(u))
            graph.get(u).add(v);
        else{
            HashSet<T> set = new HashSet<>();
            set.add(v);
            graph.put(u, set);
        }
    }

    public static <T extends Comparable<T>> List<T> bfs(GraphNode<T> startNode){
        List<T> result = new ArrayList<>();
        Queue<GraphNode<T>> queue = new LinkedList<>();
        queue.add(startNode);

        while(queue.size() > 0){
            GraphNode<T> node = queue.poll();
            result.add(node.get_value());
            for (GraphNode<T> n : node.get_neighbours()){
                if (!n.is_visited())
                    queue.add(n);
            }
        }
        return result;
    }

    public static <T> List<T> bfs(HashMap<T, HashSet<T>> graph, T start){
        List<T> result = new ArrayList<>();
        Queue<T> queue = new LinkedList<>();
        HashSet<T> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while(queue.size() > 0){
            T current = queue.poll();
            result.add(current);
            for (T adj : graph.get(current)){
                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                }
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> List<T> dfs(GraphNode<T> startNode){
        List<T> result = new ArrayList<>();
        if (startNode.is_visited())
            return result;
        result.add(startNode.get_value());
        startNode.visit();
        for (GraphNode<T> n : startNode.get_neighbours()){
            if (!n.is_visited()){
                List<T> l = dfs(n);
                result.addAll(l);
            }
        }
        return result;
    }
}
