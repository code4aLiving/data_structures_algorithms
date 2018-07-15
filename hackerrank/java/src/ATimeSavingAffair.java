import java.util.*;

public class ATimeSavingAffair {

    public static void main(String[] args) {

    }

    static class Tuple implements Comparable<Tuple> {
        int first, second;

        Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            Tuple other = (Tuple) o;
            return first == other.first && second == other.second;
        }

        @Override
        public int hashCode() {
            return first & second;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(first, o.first);
        }
    }

    static int[][] dijkstra(final int n, final int s, final Map<Integer, Set<Tuple>> graph) {
        //initialize
        final int[] distance = new int[n + 1];
        final int[] prev = new int[n + 1];
        final boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = i == s ? 0 : Integer.MAX_VALUE;
            prev[i] = -1;
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        queue.add(new Tuple(distance[s], s));

        while (queue.size() > 0) {
            // Tuple du = getMinimum(setS);
            Tuple du = queue.poll();
            int u = du.second;
            visited[u] = true;
            for (Tuple vw : graph.get(u)) {
                int v = vw.first;
                if (visited[v])
                    continue;
                Tuple tv = new Tuple(distance[v], v);
                // if (setS.contains(tv)) setS.remove(tv);
                int weight_uv = vw.second;
                if (relax(u, v, weight_uv, distance, prev)){
                    // At this point we have to do decrease key of tv
                    // queue.remove(tv); // This operation at the moment is O(n). It needs to be O(1) or O(log N)
                    tv.first = distance[v];
                    queue.add(tv); // This oi O(log N)
                }
                //setS.add(tv);
            }
        }
        return new int[][]{distance, prev};
    }

    static Tuple getMinimum(Set<Tuple> s) {
        Tuple res = new Tuple(Integer.MAX_VALUE, -1);
        for (Tuple t : s) {
            if (res.first > t.first) {
                res = t;
            }
        }
        s.remove(res);
        return res;
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
