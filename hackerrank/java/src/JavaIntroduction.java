import java.text.NumberFormat;
import java.util.Locale;

public class JavaIntroduction {

    public static String[] formatCurrency(double value){
        Locale[] currencies = new Locale[] {
                Locale.US,
                new Locale("en","IN"),
                Locale.CHINA,
                Locale.FRANCE
        };
        String[] res = new String[currencies.length];
        for (int i = 0; i < res.length; i++) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(currencies[i]);
            res[i] = nf.format(value);
        }
        return res;
    }

    public static String lexMin(String a, String b){
        int i = 0;
        while(i < Math.min(a.length(),b.length())){
            if (a.charAt(i) < b.charAt(i))
                return a;
            if (a.charAt(i) > b.charAt(i))
                return b;
            i++;
        }
        return a.length() <= b.length() ? a : b;
    }

    public static String lexMax(String a, String b){
        String lmin = lexMin(a, b);
        return lmin == a ? b : a;
    }
}
