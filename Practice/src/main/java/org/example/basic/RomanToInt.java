package org.example.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanToInt {

    public static void main(String[] args) {
       // init();
        System.out.println(romanToInt("MCMXCIV"));
    }


    static Map<Character, Set<Character>> minusMap;
    static void init() {
        Set<Character> iSet = new HashSet<>();
        iSet.add('V');
        iSet.add('X');
        Set<Character> xSet = new HashSet<>();
        xSet.add('L');
        xSet.add('C');
        Set<Character> cSet = new HashSet<>();
        cSet.add('D');
        cSet.add('M');
        minusMap = new HashMap<>();
        minusMap.put('I', iSet);
        minusMap.put('C', cSet);
        minusMap.put('X', xSet);
    }

    static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    static int getnum(char roman) {
        int num = 0;
        switch(roman) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
        }
        return num;
    }

}
