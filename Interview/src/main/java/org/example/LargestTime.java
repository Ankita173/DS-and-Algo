package org.example;

public class LargestTime {

    public static void main(String[] args) {
        int[] arr = {5,5,5,5};
        System.out.println(largestTimeFromDigits(arr));
    }

    public static String largestTimeFromDigits(int[] arr) {
        int maxhh = -1; int maxmm = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || j == k || k == i) continue;
                    int hh = arr[i]*10 + arr[j];
                    int mm = arr[k]*10 + arr[6 - i - j - k];
                    if (hh < 24 && mm < 60 && maxhh * 60 + maxmm < hh * 60 + mm) {
                        maxmm = mm;
                        maxhh = hh;
                    }
                }
            }
        }
        if(maxhh == -1 || maxmm == -1) return "";
        else {
            return padding(maxhh) + ":" + padding(maxmm);
        }
    }

    private static String padding(int num) {
        if(num < 10) return "0"+num;
        return num+"";
    }
}
