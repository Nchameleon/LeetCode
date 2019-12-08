package com.algorithm.dp;

import java.util.Scanner;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/4
 */
//用动态规划法求从顶点0到顶点12的最短路径，写出求解过程
    /*
    * 初步：只写出最短路径和
    * 1.先定义一个二维数组描述点到写一个点的路径
    * 2.这题最关键的也是利用二维数组里面的值来表达一个式子 ：
    * value[X]表示的是从零到这个点的最短距离 公式 value[x] = Math.min(value[n]+path[n][x])
    *
    *
    * */
public class PowerMiniPath {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[][] path = new int[16][16];
        int[] value = new int[16];
        value[1] = 5;
        value[2] = 3;
        //这里必须给他复一个最大值让他有一个初值和我们连接到的值进行比较
        for (int i = 3; i < value.length; i++) {
            value[i] = 100;
        }
        //这里是赋值
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                path[i][j] = cin.nextInt();
            }
        }
        cin.close();
        //主要算法
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                if (path[i][j] != 0) {
                    int temp = value[i] + path[i][j];
                    if (temp < value[j]) {
                        value[j] = temp;
                    }
                }
            }
        }
        System.out.println(value[15]);
    }
}
