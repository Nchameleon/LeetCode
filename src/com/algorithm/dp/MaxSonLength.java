package com.algorithm.dp;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/8
 */
public class MaxSonLength {
    /*
    * 求最长的公共子序列：
    * 思路：这题确实很难想到，分了三种情况考虑。
    * 第一：如果这两个字符串的最后一个字符相同的话，那么最长公共的子串一定也是包括最后一个
    * 第二：如果最后一个字符不相同的情况这种情况有可能是 text1的最后一个字符和text2从0到倒数第二个的公共字符串
    * 也可能是反着的，这种情况下已经包含了可能最后一个字符都不相同的情况
    * 设置一个dp[i][j] 表示的是text1长为i的时候和text2长为j的最长公共子串的长度
    * 如上的两种情况公式：dp[i][j] = dp[i-1][j-1]+1
    * dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
    * */
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //这里长度加一只是为了方便表示
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        String string1 = "xzyzzyx";
        String string2 = "zxyyzxz";
        System.out.println(longestCommonSubsequence(string1,string2));
    }
}
