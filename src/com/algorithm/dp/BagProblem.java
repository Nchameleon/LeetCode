package com.algorithm.dp;

import java.util.Scanner;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/4
 */
/*
* 关于01背包的问题，有n个物品，一个容器为n的背包，每个物品的价值给定
* 求在容器内能装最大价值为多少的物品
* */
public class BagProblem {
    public static void main(String[] args) {
        int N = 5;
        int V = 6;
        //这里为了方便我在前面加了一个0
        int[] w = {0,3,2,1,4,5};
        int[] v = {0,25,20,15,40,50};
        System.out.println(maxValue(v,w,V));

    }
    public static int maxValue(int[] Vbag,int[] Wbag,int V){
        int N = Vbag.length-1;
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <=N ; i++) {
            for (int j = 0; j <=V ; j++) {
                //背包装的下的情况dp[i][j] = Math.max()
                if (j>=Wbag[i]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-Wbag[i]]+Vbag[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[N][V];
    }

}
