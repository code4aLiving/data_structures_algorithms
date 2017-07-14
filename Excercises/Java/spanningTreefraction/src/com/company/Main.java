package com.company;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Edge> edges = new ArrayList<>();
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int a0 = 0; a0 < m; a0++) {
            int u = in.nextInt();
            Node un = new Node(u, null);
            if (nodes.containsKey(u))
                un = nodes.get(u);
            else
                nodes.put(u,un);

            int v = in.nextInt();
            Node vn = new Node(v, null);
            if (nodes.containsKey(v))
                vn = nodes.get(v);
            else
                nodes.put(v, vn);

            int a = in.nextInt();
            int b = in.nextInt();
            edges.add(new Edge(un, vn, a, b));
        }
        double l = 0;
        double r = Math.pow(2,60) + 1;
        double c = r;
        Fraction res = new Fraction(0,1);
        int iter = 100;
        while(iter > 0){
        //while(Math.abs(res.evaluate()-c) > 0.0000001){
            iter--;
            res = mst(edges, c);
            System.out.println(String.format("%d %d %f %f",res.p,res.q,c,res.evaluate()));
            if (res.p >= res.q * c){
                l = c;
            }
            else{
                r = c;
            }
            c = (l+r)/2;
        }
        res = simplify(res);
        System.out.println(String.format("%d/%d", res.p, res.q));
    }

    public static Fraction simplify(Fraction f){
        int a = Math.min(f.p, f.q);
        int b = Math.max(f.p, f.q);
        int g = gcd(a,b);
        return new Fraction(f.p/g, f.q/g);
    }

    public static Fraction mst(List<Edge> edges, double c){
        for (Edge e: edges) {
            e.set_weight(e.getFraction().p - (e.getFraction().q*c));
            e.vn.rank = 0;
            e.vn.setParent(e.vn);
            e.un.rank = 0;
            e.un.setParent(e.un);
        }
        Collections.sort(edges, new EdgeComparator());
        Collections.reverse(edges);
        //Build sets
        Fraction res = new Fraction(0,0);
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            Node pu = find_set(e.un);
            Node pv = find_set(e.vn);
            if (pu.key == pv.key)
                continue;
            res.q += e.getFraction().q;
            res.p += e.getFraction().p;
            //System.out.println(String.format("%d %d %d %d %d",e.un.key, e.vn.key, e.get_weight(), e.getFraction().p, e.getFraction().q));
            union(pu, pv);
        }
        return res;
    }

    public static void union(Node u, Node v){
        if (u.rank > v.rank){
            v.setParent(u);
        }
        else{
            u.setParent(v);
            if (u.rank == v.rank){
                v.rank += 1;
            }
        }
    }

    public static Node find_set(Node node){
        if (node.parent.key != node.key){
            node.parent = find_set(node.parent);
        }
        return node.parent;
    }

    public static int gcd(int a, int b){
        while(true){
            int r = b % a;
            if (r == 0)
                return a;
            b = a;
            a = r;
        }
    }
}

class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        if(o1.get_weight() > o2.get_weight())
            return 1;
        else if(o1.get_weight() == o2.get_weight())
            return 0;
        else
            return -1;
    }
}

class Fraction{
    public int p;
    public int q;
    public Fraction(int pP, int qP){
        p = pP;
        q = qP;
    }

    public float evaluate(){
        return (float)p/(float)q;
    }

}

class Edge{
    private double weight;
    public Node un, vn;
    Fraction f;
    public Edge(Node uP, Node vP, int a, int b){
        un = uP;
        vn = vP;
        f = new Fraction(a,b);
    }

    public void set_weight(double w){
        weight = w;
    }

    public double get_weight(){
        return weight;
    }

    public Fraction getFraction(){
        return f;
    }
}

class Node extends Object{
    int key, rank;
    Node parent;
    public Node(int keyP, Node parentP){
        key = keyP;
        parent = parentP;
        rank = 0;
    }
    @Override
    public boolean equals(Object other){
        Node o = (Node)other;
        return key == o.key;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(key);
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node p){
        parent = p;
    }
}
