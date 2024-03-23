package org.example.lse;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//london stock exchange
public class LSE {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 1, 1, 4, 3);

        System.out.println(isDuplicate(list1, list2));

    }

    static boolean isDuplicate(List<Integer> list1, List<Integer> list2) {
        if(list1.size() != list2.size()) return false;
        Map<Integer, Integer> freq1 = frequency(list1);
        Map<Integer, Integer> freq2 = frequency(list2);
        if(freq1.size() != freq2.size()) return false;
        for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
            if(entry.getValue() != freq2.get(entry.getKey()))
                return false;
        }
        return true;
    }

    static Map<Integer, Integer> frequency(List<Integer> list) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : list) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        return freq;
    }
}

//2 <int>list with unordered and duplicates - determine list are same ?



//    public static void main(String[] args) {
//        List<Integer> a = Arrays.asList(1, 5, 3, 5, 5);
//        //2 , [10, 6, 10, 10]
//        Object b = a.stream().filter(Objects::nonNull).map(i -> i * 2).filter(i -> i > 5).map(LSE::printAndReturn).collect(Collectors.toList());
//
//        System.out.println(b); //10
//    }
//
//    private static int printAndReturn(int i) {
//        System.out.println(i); //[10, 6, 10, 10]
//        return i;
//    }