package algorithms;

import datastructures.GraphNode;
import datastructures.Tuple;

import java.io.*;
import java.util.*;

public class GraphAlgorithms {

    public static HashMap<Integer, HashSet<Integer>> load_undirected_graph(String text)
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

    public static HashMap<Integer, HashSet<Integer>> loadDirectedGraph(String text)
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
            if (!graph.containsKey(v))
                graph.put(v, new HashSet<>());
        }
        return graph;
    }

    public static Map<Integer, Set<Tuple<Integer, Integer>>> loadDirectedWeightedGraph(String text) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(text.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
        int edges = Integer.parseInt(br.readLine().trim());

        Map<Integer, Set<Tuple<Integer, Integer>>> graph = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            String [] line = br.readLine().split(" ");
            Integer u = Integer.parseInt(line[0]);
            Integer v = Integer.parseInt(line[1]);
            Integer w = Integer.parseInt(line[2]);

            if (!graph.containsKey(u)) graph.put(u, new HashSet<>());
            graph.get(u).add(Tuple.build(v, w));
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

    public static <T> List<T> topologicalSortKarp(HashMap<T, HashSet<T>> graph){
        throw new RuntimeException();
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

    public static <T> List<T> topologicalSortKahn(HashMap<T, HashSet<T>> graph){
        HashMap<T, Integer> inDegree = new HashMap<>();
        Queue<T> queue = new LinkedList<>();
        List<T> topSort = new LinkedList<>();

        for (T u: graph.keySet()){
            if (!inDegree.containsKey(u))
                inDegree.put(u, 0);
            for (T v: graph.get(u)){
                if (inDegree.containsKey(v))
                    inDegree.replace(v, inDegree.get(v) + 1);
                else
                    inDegree.put(v, 1);
            }
        }

        for (T u: inDegree.keySet()){
            if (inDegree.get(u) == 0)
                queue.add(u);
        }

        while (queue.size() > 0){
            T u = queue.poll();
            topSort.add(u);

            for (T v: graph.get(u)){
                if (inDegree.get(v) <= 0) //already visited
                    continue;
                inDegree.replace(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0)
                    queue.add(v);
            }
        }
        return topSort;
    }

    static int[][] dijkstra(final int n, final int s, final Map<Integer, Set<Tuple<Integer, Integer>>> graph) {
        final int[] distance = new int[n + 1];
        final int[] prev = new int[n + 1];
        final boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s] = 0;

        // Priority queue of tuples <Distance to origin, Vertex>
        PriorityQueue<Tuple<Integer, Integer>> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(Tuple.build(0, s));

        while(priorityQueue.size() > 0) {
            Tuple<Integer, Integer> du = priorityQueue.poll();
            int u = du.second;
            if (visited[u]) continue;

            //Once a vertex has been extracted from the queue it reached its optimum
            visited[u] = true;

            for (Tuple<Integer, Integer> uv: graph.get(u)) {
                int v = uv.first;
                int weightuv = uv.second;
                // In the graph each tuple is an edge <vertex, weight>
                if (relax(u, v, weightuv, distance, prev)) {
                    //We could relax U ~> V
                    // Add v back to the priority queue with the new updated distance.
                    // It would be better to do decrease key but that's not available in java's priority queue
                    priorityQueue.add(Tuple.build(distance[v], v));
                }
            }
        }

        return new int[][] {distance, prev};
    }

    static boolean relax(int u, int v, int weightuv, int[] distance, int[] prev) {
        if (distance[v] > distance[u] + weightuv) {
            distance[v] = distance[u] + weightuv;
            prev[v] = u;
            return true;
        }
        return false;
    }
}
