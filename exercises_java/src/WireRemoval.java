import java.util.*;

public class WireRemoval {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode [] nodes = new TreeNode[n];

        //The input is not given as a tree but as a graph
        //Read the graph and create the tree from the graph
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            if (nodes[u] == null)
                nodes[u] = new TreeNode(u, 0,null);
            if (nodes[v] == null)
                nodes[v] = new TreeNode(v, nodes[u].depth + 1, nodes[u]);

            nodes[u].children.add(nodes[v]);
        }
        double res = wireRemoval(nodes[0], n);
        System.out.println(res);
    }



    public static double wireRemoval(TreeNode root, long n){
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
        double prob = ((double)1)/p;
        double res = 0.0;
        queue.add(root);
        while(queue.size() > 0){
            TreeNode current = queue.poll();

            res += current.depth * prob * (n - current.getSubtreeNodesCount());


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
