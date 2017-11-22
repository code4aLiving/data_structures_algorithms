import java.util.*;

public class StringReduction {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<q; i++){
            String s = sc.nextLine();
            System.out.println(stringReductionBruteForce(s));
            System.out.println(stringReductionDP(s));
        }

    }

    public static int stringReductionBruteForce(String s){
        int res = Integer.MAX_VALUE;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);

        while(queue.size() > 0){
            String current = queue.poll();
            res = Math.min(res, current.length());
            if(res == 1)
                return res;
            for (String neighbor: getNeighbors(current)){
                if (visited.contains(neighbor))
                    continue;
                queue.add(neighbor);
                visited.add(neighbor);
            }
        }
        return res;
    }

    private static Iterable<String> getNeighbors(String s){

        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1))
            i++;

        final int start = i;

        return () -> new Iterator<String>() {
            int i = start;
            @Override
            public boolean hasNext() {
                return i < s.length()-1;
            }

            @Override
            public String next() {
                char[] current = s.toCharArray();
                char[] newString = new char[current.length-1];
                for (int j=0; j<i; j++)
                    newString[j]=current[j];
                if (current[i] == 'a'){
                    if (current[i+1] == 'b')
                        newString[i] = 'c';
                    else
                        newString[i] = 'b';
                }
                if (current[i] == 'b'){
                    if (current[i+1] == 'a')
                        newString[i] = 'c';
                    else
                        newString[i] = 'a';
                }

                if (current[i] == 'c'){
                    if (current[i+1] == 'a')
                        newString[i] = 'b';
                    else
                        newString[i] = 'a';
                }

                for (int j=i+2; j<current.length; j++)
                    newString[j-1] = current[j];

                do {
                    i++;
                }while(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1));

                return new String(newString);
            }
        };
    }

    private static int[][][] canTable;
    private static int inf = 10000000;
    public static Boolean can(String s, int start, int end, char c){

        int charValue = c - 'a';
        if (start == end)
            return s.charAt(start) == c;

        if (canTable[charValue][start][end] != 0)
            return canTable[charValue][start][end] > 0;
        char u = 'a';
        char v = 'b';
        if (c == 'a') {
            u = 'b';
            v = 'c';
        }
        if (c == 'b') {
            u = 'a';
            v = 'c';
        }
        if (c == 'c') {
            u = 'a';
            v = 'b';
        }

        canTable[charValue][start][end] = -1;
        for (int i = start; i < end; i++) {
            if ((can(s, start, i, u) && can(s, i+1, end, v))
                    || (can(s, start, i, v) && can(s, i+1, end, u))) {
                canTable[charValue][start][end] = 1;
            }
        }

        return canTable[charValue][start][end] > 0;
    }

    public static int stringReductionDP(String s){
        int [][] table = new int[3][s.length()];
        canTable = new int[3][s.length()][s.length()];
        for (int ch = 0; ch <= 2; ch++) {

            for (int i = 0; i < s.length(); i++) {

                table[ch][i] = inf;
                for (int j = 0; j <= i; j++) {

                    if (can(s,j,i,(char)(ch + 'a'))){
                        table[ch][i] = j == 0 ? 1 : Math.min(table[ch][i], table[ch][j-1] + 1);
                    }
                }
            }
        }
        return Math.min(Math.min(table[0][s.length()-1],table[1][s.length()-1]),table[2][s.length()-1]);
    }
}
