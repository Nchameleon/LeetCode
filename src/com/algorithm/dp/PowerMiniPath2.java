package com.algorithm.dp;

import java.util.Scanner;

/**
 * @author 刘文月
 * @version 1.1
 * @date 2019/12/4
 */
//用动态规划法求从顶点0到顶点12的最短路径，写出求解过程
    /*
    * 初步：只写出最短路径和
    * 1.如果要打印出路径的话显然设置一个类，既可以存值又可以存上一个连接点的值
    * 2.这题最关键的也是利用二维数组里面的值来表达一个式子 ：
    * value[X]表示的是从零到这个点的最短距离 公式 value[x] = Math.min(value[n]+path[n][x])
    *
    *
    * */
public class PowerMiniPath2 {
    public static class Node{
        public int parent;

        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner ci = new Scanner(System.in);
        int[][] path = new int[16][16];
        Node[] nodes = new Node[16];
        nodes[1] = new Node(5);
        nodes[1].parent = 0;
        nodes[2] = new Node(3);
        nodes[2].parent = 0;
        //这里必须给他复一个最大值让他有一个初值和我们连接到的值进行比较
        for (int i = 3; i < nodes.length; i++) {
            nodes[i] = new Node(100);
        }
        //这里是赋值
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                path[i][j] = ci.nextInt();
            }
        }
        //主要算法
        setValue(path, nodes);
        for (int i = 15; i !=0 ; ) {
            int  x = nodes[i].parent;
            i = x;
            System.out.println(x+"-");
        }

    }

    static void setValue(int[][] path, Node[] value) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                if (path[i][j]!=0){
                    int temp =value[i].value+path[i][j];
                    if (temp<value[j].value){
                        value[j].value = temp;

                        value[j].parent = i;
                    }

                }
            }
        }
        System.out.println(value[15]);
    }
}
