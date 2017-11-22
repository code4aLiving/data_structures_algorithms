import java.util.*;

public class WireRemoval {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for (int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (!graph.containsKey(u))
                graph.put(u, new HashSet());
            graph.get(u).add(v);

            if (!graph.containsKey(v))
                graph.put(v, new HashSet());
            graph.get(v).add(u);
        }

        double res = wireRemoval2(graph, n);
        System.out.println(res);

    }

    public static double wireRemoval2(HashMap<Integer, HashSet<Integer>> graph, int n){
        int [] depth = new int[n+1];
        int [] subTreeCount = new int[n+1];
        int [] parent = new int[n+1];
        double prob = 0.0;
        Queue<Integer> queue = new LinkedList();

        //Calculate dep and subTreeCount
        CalculateDepthAndProb(graph, depth, subTreeCount, 1, parent);
        for (int i = 1; i < depth.length; i++) {
            prob += depth[i];
        }
        prob = 1.0 / prob;
        queue.add(1);
        double res = 0.0;
        HashSet<Integer> visited = new HashSet<>();
        while (queue.size() > 0){
            int current = queue.poll();
            res += depth[current] * prob * (n - subTreeCount[current]);
            visited.add(current);
            for (Integer next: graph.get(current)){
                if (visited.contains(next))
                    continue;
                queue.add(next);
            }
        }
        return res;
    }

    public static void CalculateDepthAndProb(HashMap<Integer, HashSet<Integer>> graph, int [] depth,
                                             int [] subTreeCount, int current, int [] parent){
        if (parent[current] == 0)
            depth[current] = 0;
        else
            depth[current] = depth[parent[current]] + 1;

        subTreeCount[current] = 1;
        for (Integer next : graph.get(current)){
            if (parent[next] > 0 || next == 1)
                continue;
            parent[next] = current;
            CalculateDepthAndProb(graph, depth, subTreeCount, next, parent);
            subTreeCount[current] += subTreeCount[next];
        }
    }
}
