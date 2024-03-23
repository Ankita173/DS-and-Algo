package org.example.basic;

public class StringPermutation {

    public static void main(String[] args) {
        String s1 = "prosperity";
        String s2 = "properties";
        if(s1.equals(s2)) System.out.println(true);
        else if(s1.length() > s2.length()) System.out.println(false);
        else {
            String flag = "";
            for (int i = 0; i < s1.length(); i++) {
                flag = flag.concat("f");
            }
            System.out.println(backtrack(s1, s2, "", flag));
        }
    }

    private static boolean backtrack(String s1, String s2, String perm, String flag) {
        if (perm.length() == s1.length()) {
            if(s2.contains(perm))
                return true;
            else
                return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if(flag.substring(i, i+1).equals("t")) continue;
            perm = perm.concat(s1.substring(i, i+1));
            flag = i < s1.length() - 1 ? flag.substring(0, i) + "t" + flag.substring(i+1, flag.length())
                    : flag.substring(0, i) + "t";
            if (backtrack(s1, s2, perm, flag)) {
                return true;
            }
            flag = i < s1.length() - 1 ? flag.substring(0, i) + "f" + flag.substring(i+1, flag.length())
                    : flag.substring(0, i) + "f";
            perm = perm.substring(0, perm.length()-1);
        }
        return false;
    }
}