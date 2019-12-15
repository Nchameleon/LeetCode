package com.algorithm.search;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/12
 */
public class LeetCode668 {

    public int findKthNumber(int m, int n, int k) {
        if (m==0||n==0||k==0) return 0;
        int left = 1;
        int right = m*n;
        while(left < right){
            int mid = (left+right)>>1;
            int count = getCount(m,n,mid);
            if (count>=k){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    private int getCount(int m,int n,int mid){
        int count = 0;
        int m1 = m;
        int n1 = 1;
        int temp = m;
        while(n1<=n&&m1>0){
            if (temp>mid){
                m1--;
                temp = m1*n1;
            }else{
                count += m1;
                temp = m1*(++n1);
            }
        }
        return count;
    }
}
