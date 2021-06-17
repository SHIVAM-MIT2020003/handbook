package cheatsheet;

import java.util.*;

public class StringModules {

    public String largestNumber(final int[] A) {
//        330004 > 33 (lexicographically)
        List<String> l = new ArrayList<>();
        for (int a : A){
            l.add(a + "");
        }
        Collections.sort(l, (a, b) -> (b + a ).compareTo(a + b));

        StringBuilder str = new StringBuilder("");

        for (String s : l){
            str.append(s);
        }
        int i = 0;
        for (i = 0; i < str.length(); i++){
            if(str.charAt(i) != '0')
                return str.substring(i).toString();
        }
        return "0";
    }
}
