package algorithms;

import datastructures.Tuple;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphAlgorithmsTest {

    @Test
    public void load_undirected_graph() {
    }

    @Test
    public void loadDirectedGraph() {
    }

    @Test
    public void add_edge() {
    }

    @Test
    public void bfs() {
    }

    @Test
    public void bfs1() {
    }

    @Test
    public void topologicalSortKarp() {
    }

    @Test
    public void dfs() {
    }

    @Test
    public void topologicalSortKahn() {
    }

    @Test
    public void dijkstra() throws IOException {

        //The graph used in this unit test is found on the page 659 of the Introduction to Algorithms.

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("directed_graph_dijkstra_test").getFile());
        byte [] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        String text = new String(encoded);
        Map<Integer, Set<Tuple<Integer, Integer>>> graph = GraphAlgorithms.loadDirectedWeightedGraph(text);
        int[][] x = GraphAlgorithms.dijkstra(5, 1, graph);
        int[] distance = x[0];
        int[] prev = x[1];

        int [] expectedDistance = {0, 0, 8, 5, 9, 7};
        int [] expectedPrev = {0, 0, 3, 1, 2, 3};

        assertEquals(6, distance.length);
        assertEquals(6, prev.length);
        for (int i = 0; i < distance.length; i++) {
            assertEquals(expectedDistance[i], distance[i]);
            assertEquals(expectedPrev[i], prev[i]);
        }
    }

    @Test
    public void relax() {
    }
}