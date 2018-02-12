
import java.util.*;

public class roadsAndLibraries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long q = sc.nextInt();
        for (long i = 0; i < q; i++) {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long cl = sc.nextInt();
            long cr = sc.nextInt();
            Map<Long, List<Long>> graph = new HashMap<>();
            for(long k=1; k<=n; k++){
                graph.put(k, new ArrayList<>());
            }
            for (long j = 0; j < m; j++) {
                final long u = sc.nextInt();
                final long v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            System.out.println(solve(n, m, cl, cr, graph));
        }
    }

    public static long solve(long n, long m, long cl, long cr, Map<Long, List<Long>> graph) {
        if (cr >= cl)
            return n * cl;

        HashSet<Long> visited = new HashSet<Long>();
        Queue<Long> queue = new LinkedList<Long>();
        long res = 0;
        for (long i = 1; i <= n; i++) {
            if (visited.contains(i)) continue;
            long vertexCount = 0;
            queue.add(i);
            visited.add(i);
            while (queue.size() > 0) {
                long current = queue.poll();
                vertexCount++;
                for (Long v : graph.get(current)) {
                    if (visited.contains(v)) continue;
                    visited.add(v);
                    queue.add(v);
                }
            }
            res += cl + (vertexCount-1)*cr;
        }
        return res;
    }
}
