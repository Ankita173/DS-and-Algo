package org.example.zoom;

public class BestTimeToBuyStock {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        int[] stocks = {10,5,15,20,2,35,1,39};
        System.out.println(bestBuy(stocks));

        int[] stocks1 = {5,45, 1, 30, 20, 19, 4, 5};
        System.out.println(bestBuy(stocks1));


    }

    static int bestBuy(int[] stock) {
        int buyTime = 0;
        int sellTime = 0;
        int maxProfit = 0;
        int min = 0;
        for(int i = stock.length - 1; i > 0; i--) {
            min = stock[i - 1] - 1;
            for(int j = i - 1; j >= 0; j--) {
                if (min < stock[j] && stock[j] < stock[i]) {
                    int sell = stock[i] - stock[j];
                    if (maxProfit < sell) {
                        maxProfit = sell;
                        buyTime = i+1;
                        sellTime = j+1;
                    }
                    min = stock[j];
                }
            }
        }
        System.out.println("Best buy time :" + sellTime);
        System.out.println("Best sell time :" + buyTime);
        return maxProfit;
    }
}

//Stock
//Array of prices of daily stock price :
//case1: [10,5,15,20,2,35,1,39] -> 1 ->39
//Case2: [5,45, 1, 30, 20, 19, 4, 5] ->5,14
//best time to buy and sell of stock to gain max profit

