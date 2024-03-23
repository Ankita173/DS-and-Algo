package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PartitionSubstring {

    public static void main(String[] args) {
        System.out.println(partition("aabbcc"));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generate(s, 0, ans, new ArrayList<>());
        return ans;
    }

    static void generate(String s,int start, List<List<String>> ans, List<String> curr) {
        if(start >= s.length())
            ans.add(new ArrayList<>(curr));
        for(int i=start;i<s.length();i++)
        {
            if(isPalindrome(s,start,i))
            {
                curr.add(s.substring(start,i+1));
                generate(s, i+1, ans, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    static boolean isPalindrome(String str, int low, int high) {
        while(low < high) {
            if (str.charAt(low++) != str.charAt(high--))
                return false;
        }
        return true;
    }


}
