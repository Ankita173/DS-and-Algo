package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Long.parseLong;

public class SumNumberToTarget {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter total numbers of element in an array: ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter "+size+" numbers in ascending order");
        int[] arr = new int[size];
        for (int i = 0 ; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter target sum ");
        long sum = parseLong(br.readLine());
        findIndexesToSum(arr,sum);
    }


    ///assuming arr is in asc order
    static void findIndexesToSum(int[] arr, long sum) {
        for (int i=0, j= arr.length-1; i <= j;) {
            if (arr[i] + arr[j] == sum) {
                System.out.println("found index "+(i+1)+" and "+(j+1)+" with value "+arr[i]+" "+arr[j]+" which equals to "+sum);
                break;
            } else if (arr[i] + arr[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
    }


}
