package com.algorithm.dp;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/15
 */
//这题比上一题多了一个条件是在遇到障碍的时候表示是不能通过的
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i <m ; i++) {
            if (obstacleGrid[0][i] == 1){
                while(i!=m){
                    dp[0][i++] = 0;
                }
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i <n ; i++) {
            if (obstacleGrid[i][0] == 1){
                while(i!=n){
                    dp[i++][0] = 0;
                }
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
