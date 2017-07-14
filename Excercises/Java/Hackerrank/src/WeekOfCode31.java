import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sergio on 13/04/17.
 */
public class WeekOfCode31 {

    public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int a0 = 0; a0 < m; a0++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            edges.add(new Edge(u, v, a, b));
        }
    }

    public static int spanningTreeFraction(List<Edge> edges){
        return 0;
    }
}

class Fraction{
    public int p;
    public int q;
    public Fraction(int pP, int qP){
        p = pP;
        q = qP;
    }
}

class Edge{
    int u, v;
    Fraction f;
    public Edge(int uP, int vP, int a, int b){
        u = uP;
        v = vP;
        f = new Fraction(a,b);
    }
}
