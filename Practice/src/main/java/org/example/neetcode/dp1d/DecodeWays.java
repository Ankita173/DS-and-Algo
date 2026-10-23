package org.example.neetcode.dp1d;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("07"));
    }

    public  int numDecodings(String s) {
        index.put(s.length(), 1);
        return countDecode(s, 0);
    }
    Map<Integer, Integer> index = new HashMap<>();
    private int countDecode(String s, int i) {
        if (index.containsKey(i)) return index.get(i);
        if (s.charAt(i) == '0') return 0;
        int count = countDecode(s, i + 1);
        if (i + 1 < s.length() &&
                (s.charAt(i) == '1' ||
                        (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
            count += countDecode(s, i + 2);

        index.put(i, count);
        return count;
    }
}
