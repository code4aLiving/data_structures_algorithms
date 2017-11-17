public class DecryptMessages {

    public static String answer(String s) {
        String sb = "";
        int a = (int)'a';
        int z = (int)'z';
        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            int val = (int)c;
            if (val < a || val > z){
                sb += c;
                continue;
            }
            sb += ((char)(a+z-val));
        }
        return sb;
    }
}
