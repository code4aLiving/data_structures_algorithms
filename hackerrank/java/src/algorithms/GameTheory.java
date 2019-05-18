package algorithms;

public class GameTheory {

    public static int nim(int [] piles) {
        int res = 0;
        for(int i = 0; i< piles.length; i++){
            res = res ^ piles[i];
        }
        if(res != 0)
            return 0;
        return 1;
    }
}
