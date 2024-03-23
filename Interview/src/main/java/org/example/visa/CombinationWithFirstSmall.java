package org.example.visa;

import java.util.ArrayList;
import java.util.List;

public class CombinationWithFirstSmall {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        backtract(input, output, new ArrayList<>(), 0);
    }

    static void backtract(List<Integer> input, List<List<Integer>> output, List<Integer> comb, int start) {
        if (!comb.isEmpty() && isFirstSmall(comb)) {
            output.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < input.size(); i++){
            comb.add(input.get(i));
            backtract(input, output, comb, i+1);
            comb.remove(comb.size() - 1);
        }
    }

    static boolean isFirstSmall(List<Integer> comb) {
        for (int j = 1; j < comb.size(); j++) {
            if (comb.get(0) > comb.get(j))
                return false;
        }
        return true;
    }
}
