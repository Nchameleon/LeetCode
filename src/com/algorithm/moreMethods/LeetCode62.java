package com.algorithm.moreMethods;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/15
 */
public class LeetCode62 {
    int count = 0;

    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();

        int temp = leetCode62.uniquePaths(7,3);
        System.out.println(temp);
    }
    public int uniquePaths(int m, int n) {
        figureOut(0,0,m,n);
        return count;
    }
    public void figureOut(int x,int y,int m, int n){
        if (x>m||y>n) return;
        if (x==(m-1)&&y==(n-1) ){
            count++;
            return;
        }
        figureOut(x+1,y,m,n);
        figureOut(x,y+1,m,n);
    }
}
