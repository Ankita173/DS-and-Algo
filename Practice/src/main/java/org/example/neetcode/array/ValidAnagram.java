package org.example.neetcode.array;

public class ValidAnagram {


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {


        System.out.println(s);
        System.out.println(t);
        if (s.length() == t.length()) {
            int[] array = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index1 = s.charAt(i) - 'a';
                array[index1] += 1;
                int index2 = t.charAt(i) - 'a';
                array[index2] -= 1;
            }
            for (int i : array) {
                if(i != 0) return false;
            }
            return true;
        }
        return false;



//        if (s.length() == t.length()) {
//            Map<Character, Integer> frequency = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                if(frequency.containsKey(s.charAt(i))) {
//                    frequency.put(s.charAt(i), 1 + frequency.get(s.charAt(i)));
//                } else {
//                    frequency.put(s.charAt(i), 1);
//                }
//                if (frequency.containsKey(t.charAt(i))) {
//                    frequency.put(t.charAt(i), frequency.get(t.charAt(i)) - 1);
//                } else {
//                    frequency.put(t.charAt(i), -1);
//                }
//            }
//            System.out.println(frequency);
//            for (Map.Entry row : frequency.entrySet()) {
//                if(!row.getValue().equals(0)) return false;
//            }
//            return true;
//        }
//        return false;
    }
}
