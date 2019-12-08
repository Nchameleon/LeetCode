package com.algorithm.dp;

import java.util.Scanner;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/5
 */
/*
*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
* 思路我一开始的思路是先设置一个dp[][] 把基本的初始值给最大值，然后去看下一个点的上一个点是否存在，最后比较
* 但是测试的时候错误了。这是一个典型的二维的动态规划，下一个节点要么从左边到右边，要么从上边到下面
* 给定开始的最上边的值和最左边的值
* 这个题不具有解决从第一个点到任意点的最短路径的通性，只适合从0行0列到行和列都大于0的情况
* */
public class LeetCode64 {
    public static void main(String[] args) {
        int[][] a = new int[3][2];
        System.out.println(a.length);
    }
    public int minPathSum(int[][] grid) {
        if (grid == null||grid[0].length == 0||grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //为最上面的一行赋值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                dp[i][j] = Math.min(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
