package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] weights = {1,1,1,1};
        int [] positions = {1,2,3,4};
        int n = 4;
        int k = 3;

        System.out.println(poles(n,k,weights,positions));
    }
    public static int poles(int n, int k, int [] weights, int [] positions){
        int res = Integer.MAX_VALUE;
        int [][] table = new int[k][n];
        int[][] costs = costs(weights,positions);
        for (int row = 0; row < k-1; row++) {
            for (int col = row + 1; col <= n-k+row; col++) {
                if (row == 0)
                    table[row][col] = costs[0][col];
                else{
                    int tempRes = Integer.MAX_VALUE;
                    for (int i = row-1; i < col; i++) {
                        tempRes = Math.min(tempRes,table[row-1][i] + costs[i+1][col]);
                    }
                    table[row][col] = tempRes;
                }
            }

        }
        if(k==1){
            return costs[0][n-1];
        }
        for (int col = 0; col < n-1; col++) {
            if(res > table[k-2][col] + costs[col+1][n-1]){
                res = table[k-2][col] + costs[col+1][n-1];
                //System.out.println(positions[col]);
            }

        }
        return res;
    }

    public static int [][] costs(int [] weights, int [] positions){
        int [][] res = new int[weights.length][weights.length];
        for (int i = 0; i < res[0].length; i++) {
            for (int j = i+1; j < res[0].length; j++) {
                for (int k = i; k <= j ; k++) {
                    res[i][j] += weights[k]*(positions[k]-positions[i]);
                }
            }
        }
        return res;
    }
}
