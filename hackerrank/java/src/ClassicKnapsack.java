
/**
 * Created by sergio on 24/08/17.
 * Given a set of items, each with a weight and a value, determine the Integer of each item to include in a collection
 * so that the total weight is less than or equal to a given limit and the total value is as large as possible
 */
public class ClassicKnapsack {

    public static void main(String[] args){

    }

    public static int max_profit(int [] weights, int [] values, int capacity){
        int [][] table = new int[capacity][values.length + 1];
        for(int row=1; row<capacity; row++){
            for (int col=0; col<values.length; col++){
                int prevCap = row - weights[col];
                if (weights[col] > row || prevCap < 0)
                    table[row][col] = table[row][col-1];
                else{
                    table[row][col] = Math.max(table[row][col-1], values[col] + table[prevCap][col-1]);
                }
            }
        }
        return table[capacity-1][values.length];
    }

    public static int[] items_max_profit(int [] weights, int [] values, int capacity){
        throw new RuntimeException();
    }
}
