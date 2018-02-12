import java.util.*;

public class RedKnightsShortestPath {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        ParentCell cell = shortestPath(n, i_start, j_start, i_end, j_end);

        LinkedList<String> printRes = new LinkedList<>();
        if (cell.distance > 100000000)
            System.out.println("Impossible");
        else {
            System.out.println(cell.distance);
            while(cell != null && cell.move != ""){
                printRes.addFirst(cell.move + " ");
                cell = cell.parent;
            }

            for (String s:printRes
                    ) {
                System.out.print(s);
            }
        }

        in.close();
    }

    public static ParentCell shortestPath(int n, int srow, int scol, int frow, int fcol){

        Queue<ParentCell> queue = new LinkedList<>();
        ParentCell start = new ParentCell(srow, scol, "", null);
        start.distance = 0;
        HashSet<ParentCell> visited = new HashSet<>();
        ParentCell end = new ParentCell(frow, fcol, null, null);
        queue.add(start);
        visited.add(start);

        while(queue.size() > 0){
            ParentCell current = queue.poll();
            if (current.equals(end)){
                end = current;
                break;
            }

            for (ParentCell cell: getNeigbors(current, n)) {
                if (!visited.contains(cell)){
                    //New not explored cell
                    cell.distance = current.distance + 1;
                    cell.parent = current;
                    queue.add(cell);
                    visited.add(cell);
                }
            }
        }

        return end;
    }

    private static List<ParentCell> getNeigbors(ParentCell cell, int n){
        String [] moves = {"UL", "UR", "R", "LR", "LL", "L" };
        int [] movesDeltaRow = {-2, -2, 0, 2, 2, 0};
        int [] movesDeltaCol = {-1, 1, 2, 1, -1, -2};
        List<ParentCell> res = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int row = cell.row + movesDeltaRow[i];
            int col = cell.col + movesDeltaCol[i];
            if (row >= 0 && row < n && col >=0 && col<n) {
                ParentCell nCell = new ParentCell(row, col, moves[i], cell);
                res.add(nCell);
            }
        }

        return res;
    }

    private static class ParentCell
    {
        public Integer row;
        public Integer col;
        public String move;
        public ParentCell parent;
        public int distance = Integer.MAX_VALUE;

        public ParentCell(int rowP, int colP, String moveP, ParentCell parentP){
            row = rowP;
            col = colP;
            move = moveP;
            parent = parentP;
        }


        @Override
        public boolean equals(Object obj) {
            ParentCell other = (ParentCell)obj;
            return row == other.row && col == other.col;
        }

        @Override
        public int hashCode(){
            return row.hashCode() & col.hashCode();
        }
    }
}
