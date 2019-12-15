package com.algorithm.otherSort;

import java.util.Arrays;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/9
 */
public class MergeSot {
    public static void main(String[] args) {
        int[] arry = {8,2,4,5,1,3,5,8};
        mergeSort(arry,0,arry.length-1);
        System.out.println(Arrays.toString(arry));

    }
    //归并排序的思想，先分开排左右两边，然后合并。用递归一步一步的下去直到只有一个元素
    public static void mergeSort(int[] arr,int left,int right) {
        if (left == right) return;
        int mid = (left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        //这里是从最小的一步开始的，也就是只有两个元素的排序然后合并，然后一步步推到整个数组
        Meger(arr,left,mid,right);
    }
    //最关键的是怎么给两边的排序然后比较,
    public static void Meger(int[] arr,int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        while(p1<=mid&&p2<=right){
            //给temp[]这个数组赋值
            temp[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            temp[i++] = arr[p1++];
        }
        while (p2<=right){
            temp[i++] = arr[p2++];
        }
        //最后通过temp的值改变arr的值
        for (int j = 0; j <temp.length ; j++) {
            arr[left+j] = temp[j];
        }
    }
}
