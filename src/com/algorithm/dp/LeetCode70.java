package com.algorithm.dp;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/15
 */

public class LeetCode70 {
    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        int temp = leetCode70.climbStairs(5);
        System.out.println(temp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if (n==1&&n==2) return dp[n];
        int i = 3;
        while(i<=n){
            dp[i] = dp[i-1]+dp[i-2];
            i++;
        }
        return dp[n];
    }
}
