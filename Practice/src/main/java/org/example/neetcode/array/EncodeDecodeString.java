package org.example.neetcode.array;

import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("lint",":","love","you");
        String encode = encode(list);
        System.out.println(encode);
        System.out.println(decode(encode));

    }

    public static String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str : strs) encode.append(str).append(":;");
        return encode.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        String[] decode = str.split(":;");
        return Arrays.asList(decode);
    }
}
