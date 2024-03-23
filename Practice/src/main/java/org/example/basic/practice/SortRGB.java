package org.example.basic.practice;
//* [R, G, B, R, G, B] = sort as [R R G G B B]

public class SortRGB {
    public static void main(String[] args) {
        String[] colors = {"B", "G", "B", "B", "G", "R"};
        sort3Colors(colors);
        for (String s : colors)
            System.out.println(s);
        String[] colors1 = {"B", "G", "B", "B", "G", "B"};
        sort3Colors(colors1);
        for (String s : colors1)
            System.out.println(s);
    }
    static void sort3Colors(String[] colors) {
        int i = 0, j = colors.length - 1, k = 0;
        while (k <= j) {
            if (colors[k].equals("R") && k != i) {
                swap(i, k, colors);
                i++;
            } else if (colors[k].equals("B") && k != j) {
                swap(j, k, colors);
                j--;
            } else k++;
        }
    }
    static void swap(int i, int j, String[] colors) {
        String temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;

    }
}
