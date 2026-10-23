package org.example.datastructure;

public class NumberToRoman {
    public static void main(String[] args) {
        System.out.printf(convert(3749));


    }

    private static String convert(int num) {
        StringBuffer sb = new StringBuffer();

        int[] value =   {1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,   1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                sb.append(roman[i]);
                num = num - value[i];
            }
        }

        return sb.toString();
    }
}
