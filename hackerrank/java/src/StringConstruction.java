import algorithms.StringMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringConstruction {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        System.out.println(solveRec(s, x, y, 0));
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 30000; i++) {
            sf.append('a');
        }
        String s = sf.toString();
        long time = System.currentTimeMillis();
        System.out.println("Working ...");
        System.out.println(solve(s, 1, 2));
        System.out.println(String.format("Took %f seconds", (System.currentTimeMillis() - time) / 1000.0));
    }

    public static int solveRec(String s, int x, int y, int index) {
        int n = s.length();
        if (index == n) return 0;
        int maxSubstringLength = maxCloneLength(s, index);

        if (maxSubstringLength == 0)
            return solveRec(s, x, y, index + 1) + x;
        if (maxSubstringLength == 1)
            return solveRec(s, x, y, index + 1) + Math.min(x, y);
        return Math.min(solveRec(s, x, y, index + 1) + x, solveRec(s, x, y, index + maxSubstringLength) + y);
    }

    public static long solve(String s, int x, int y) {
        long[] arr = new long[s.length() + 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int cloneLength = maxCloneLength(s, i);
            if (cloneLength <= 0) arr[i] = arr[i + 1] + x;
            else {
                arr[i] = Math.min(arr[i + 1] + x, arr[i + cloneLength] + y);
            }
        }
        return arr[0];
    }

    public static long solve2(String s, int x, int y) {
        // Build table with the KMP prefix function for every suffix of s
        int[][] table = new int[s.length()][s.length()];
        for (int row = 0; row < s.length(); row++) {
            String p = s.substring(row);
            int[] prefixArr = StringMatching.computePrefix(p);
            for (int i = 1; i < prefixArr.length; i++) {
                table[row][row + i - 1] = prefixArr[i];
            }
        }
        // Build table with the KMP prefix function for every suffix of s

        long[] arr = new long[s.length()];
        arr[0] = x;
        for (int col = 1; col < arr.length; col++) {
            int cloneLength = 0;
            for (int row = 0; row < col; row++) {
                cloneLength = Math.max(cloneLength, table[row][col]);
            }
            if (cloneLength == 0) {
                arr[col] = x + arr[col - 1];
                System.out.println(String.format("Add x: %d", x));
            } else {
                if (x + arr[col - 1] < y + arr[col - cloneLength]) {
                    System.out.println(String.format("Add x: %d", x));
                } else {
                    System.out.println(String.format("Clone y: %d", y));
                }
                if (cloneLength > 1) {
                    if (isPalindrome(s, col - cloneLength - 1, col)) {
                        cloneLength = cloneLength / 2 + 1;
                    }
                }
                arr[col] = Math.min(x + arr[col - 1], y + arr[col - cloneLength]);
            }
        }
        return arr[arr.length - 1];
    }

    public static long solve3(String s, int x, int y) {
        char[] arr = s.toCharArray();
        int bestClones = 0;
        int bestShift = 1;
        int shift = 1;
        while (shift < arr.length) {
            int clones = 0;
            for (int i = shift; i < arr.length; i++) {
                if (arr[i] == arr[i - shift]) {
                    clones++;
                }
            }
            if (clones > bestClones) {
                bestClones = clones;
                bestShift = shift;
            }
            shift++;
        }

        if (bestClones == 0) {
            // All append
            return arr.length * x;
        }
        int res = bestShift * x;
        shift = bestShift;
        for (int i = bestShift; i < arr.length; i++) {
            if (arr[i] != arr[i - bestShift]) {
                res += x;
                shift++;
            } else {
                // Found a clone block
                int blockCount = 0;
                while (i < arr.length && arr[i] == arr[i - bestShift] && blockCount < shift) {
                    blockCount++;
                    i++;
                }
                shift += blockCount;
                res += Math.min(blockCount * x, y);
                i--;
            }
        }
        return res;
    }

    public static long solve4(String s, int x, int y) {
        final long[] arr = new long[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.MAX_VALUE;
        }
        final char[] text = s.toCharArray();
        arr[0] = x;
        for (int i = 1; i < s.length(); i++) {
            char c = text[i];
            List<Character> pattern = new ArrayList<>() {{
                add(c);
            }};
            if (arr[i-1] == arr[i])
                // This has already reached its best value
                continue;

            if (contains(text, pattern, 0, i - 1)) {
                arr[i] = Math.min(arr[i], Math.min(arr[i - 1] + x, arr[i - 1] + y));
                // Start matching clones
                for (int j = i + 1; j < arr.length; j++) {
                    pattern.add(text[j]);
                    if (!contains(text, pattern, 0, i - 1)) {
                        break;
                    }
                    arr[j] = Math.min(arr[j], Math.min(arr[j - 1] + x, arr[i - 1] + y));
                }
            } else {
                // Just append
                arr[i] = arr[i - 1] + x;
            }
        }
        return arr[arr.length - 1];
    }

    private static boolean contains(char[] arr, List<Character> pattern, int start, int end) {
        if (pattern.size() > end - start + 1)
            return false;
        for (int i = start; i <= end; i++) {
            int j = 0;
            boolean match = true;
            while (j < pattern.size()) {
                if (arr[i + j] != pattern.get(j) || i + j > end) {
                    match = false;
                    break;
                }
                j++;
            }
            if (match)
                return true;
        }
        return false;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private static int maxCloneLength(String s, int index) {
        int res = 0;
        for (int i = 0; i < index; i++) {
            res = Math.max(res, maxCloneLength(s, i, index));
        }
        return res;
    }

    private static int maxCloneLength(String s, int start, int index) {
        int res = 0;
        int i = 0;
        while (start + i < index && index + i < s.length() && s.charAt(start + i) == s.charAt(index + i)) {
            res++;
            i++;
        }
        return res;
    }
}
