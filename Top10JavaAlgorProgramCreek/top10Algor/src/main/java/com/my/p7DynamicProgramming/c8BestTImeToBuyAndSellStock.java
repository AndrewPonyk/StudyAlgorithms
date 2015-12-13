package com.my.p7DynamicProgramming;


import org.junit.Assert;

public class c8BestTImeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("Best time to buy and sell stock\n");

        test1();
        test2();
        test3();
    }

    public static int maxProfit(int[] mas) {
        int profit = 0;
        int minElement = mas[0];

        for (int i = 0; i < mas.length; i++) {
            profit = Math.max(mas[i] - minElement, profit);
            minElement = Math.min(minElement, mas[i]);

        }
        return profit;
    }

    public static void test1(){
        int [] mas = {10, 5, 4, 10, 15, 22, 5, 30};
        Assert.assertEquals(26, maxProfit(mas));
    }

    public static void test2(){
        int [] mas = {10};
        Assert.assertEquals(0, maxProfit(mas));
    }

    public static void test3(){
        int [] mas = {10, 20};
        Assert.assertEquals(10, maxProfit(mas));
    }

}