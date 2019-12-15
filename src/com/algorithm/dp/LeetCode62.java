package com.algorithm.dp;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/15
 */
//在LeetCode上递归的话会超出时间限制，这题的优化在于因为递归会重复很多已经找到了的值。
//这题使用动态规划 dp[i][j] = dp[i-1][j] +dp[i][j-1] 对于第一列和第一行显然是固定了的值
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        for (int i = 0; i <m ; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i <n ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
