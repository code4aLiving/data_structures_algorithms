import java.util.*;

public class WireRemoval {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode [] nodes = new TreeNode[n];
        HashMap<Integer, List<Integer>> graph = new HashMap();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            if (graph.containsKey(u))
                graph.get(u).add(v);
            else{
                graph.put(u, new ArrayList<>());
                graph.get(u).add(v);
            }

            if (graph.containsKey(v)){
                graph.get(v).add(u);
            }
            else{
                graph.put(v, new ArrayList<>());
                graph.get(v).add(u);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (queue.size() > 0){
            int current = queue.poll();
            if (nodes[current] != null)
                continue;
            if (nodes[current] == null)
                nodes[current] = new TreeNode(current, 0, null);
            for (int adj :
                    graph.get(current)) {
                if (nodes[adj] == null)
                    nodes[adj] = new TreeNode(adj, nodes[current].depth + 1, nodes[current]);
                else{
                    nodes[adj].depth = nodes[current].depth + 1;
                    nodes[adj].parent = nodes[current];
                }
                nodes[current].children.add(nodes[adj]);
                queue.add(adj);
            }
        }

        double res = wireRemoval(nodes[0], n);
        System.out.println(res);
    }



    public static float wireRemoval(TreeNode root, long n){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        long p = 0;
        while(queue.size()>0){
            TreeNode current = queue.poll();
            p += current.depth;
            for (TreeNode child :
                    current.children) {
                queue.add(child);
            }
        }
        float prob = (float)p;
        float res = 0.0f;
        queue.add(root);
        while(queue.size() > 0){
            TreeNode current = queue.poll();

            res += (current.depth / prob) * (n - current.getSubtreeNodesCount());


            for (TreeNode child :
                    current.children) {
                queue.add(child);
            }
        }

        return res;
    }

    static class TreeNode{

        public int id;
        public List<TreeNode> children;
        public long depth;
        private int subtreeNodesCount = 0;
        public TreeNode parent;
        public TreeNode(int idP, long depthP, TreeNode parentP){
            children = new ArrayList<>();
            id = idP;
            depth = depthP;
            parent = parentP;
        }

        public long getSubtreeNodesCount(){
            if (subtreeNodesCount > 0)
                return subtreeNodesCount;

            if (children.size() == 0){
                subtreeNodesCount = 1;
            }
            else{
                for (TreeNode child :
                        children) {
                    subtreeNodesCount += child.getSubtreeNodesCount();
                }
                subtreeNodesCount++;
            }

            return subtreeNodesCount;

        }
    }
}
