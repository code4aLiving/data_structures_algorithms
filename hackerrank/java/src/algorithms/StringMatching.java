package algorithms;

public class StringMatching {

    public static int[] computePrefix(String s) {
        int [] res = new int[s.length() + 1];
        int k = 0;
        for (int q = 1; q < s.length(); q++) {
            while (k > 0 && s.charAt(k) != s.charAt(q)) {
                k = res[k];
            }
            if (s.charAt(k) == s.charAt(q)) {
                k++;
            }
            res[q+1] = k;
        }
        return res;
    }
}
