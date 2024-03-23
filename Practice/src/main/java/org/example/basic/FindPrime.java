package org.example.basic;

public class FindPrime {

    public static void main(String[] args) {
        int num = 29;
        System.out.println("Is "+ num + " prime: " + isPrime(num));
    }

    private static boolean isPrime(int num ){
        if (num < 2) {
            return false;
        } else {
            for(int i = 2; i < num/2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
