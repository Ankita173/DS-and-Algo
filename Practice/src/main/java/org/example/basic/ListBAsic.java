package org.example.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListBAsic {
    public static void main(String[] args) {
        List<List<String>> name = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "b"));
        List<String> r = name.stream().flatMap(n -> n.stream()).filter(s -> ((String) s).startsWith("a")).collect(Collectors.toList());
        System.out.println(r);
    }
}
