package com.my.p7DynamicProgramming;


import static org.junit.Assert.assertEquals;

public class с8BestTimeToBuyAndSellManyTransactions {
    public static void main(String[] args) {
        System.out.println("Best Time To Buy And Sell Many Transactions");

        test1();
        test2();
        test3();
    }

    public static int maxProfitManyTransactions(int[] prices){
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
        return  profit;
    }

    public static void test1(){
        int[] mas = {4, 1, 10, 35, 22, 10, 1};// 9 + 25
        assertEquals(34, maxProfitManyTransactions(mas));
    }

    public static void test2(){
        int[] mas = {4};
        assertEquals(0, maxProfitManyTransactions(mas));
    }

    public static void test3(){
        int[] mas = {1, 5, 10};
        assertEquals(9, maxProfitManyTransactions(mas));
    }
}
