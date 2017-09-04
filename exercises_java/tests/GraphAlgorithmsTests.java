import algorithms.GraphAlgorithms;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class GraphAlgorithmsTests {

    @Test
    public void bfs_test() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("small_graph").getFile());
        byte [] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        String text = new String(encoded);
        HashMap<Integer, HashSet<Integer>> graph = GraphAlgorithms.load_undirected_graph(text);

        List<Integer> bfsResult = GraphAlgorithms.bfs(graph, 1);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        for (int i = 0; i < bfsResult.size(); i++) {
            assertEquals(expected.get(i), bfsResult.get(i));
        }
    }

    @Test
    public void dfs_test(){

    }
}

