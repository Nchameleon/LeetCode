package com.algorithm.search;

import java.util.Arrays;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/12
 */
//找出第k小的距离对
public class LeetCode719 {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums.length ==0 ||nums==null||k==0) return 0;
        Arrays.sort(nums);
        //不能确定最小值是多少，定义一个比可能最小值还小的值
        int left = 0;
        int right = nums[nums.length-1]-nums[0];
        while(left<right){
            int mid = (left+right)>>1;
            int count = 0;
            int Lindex = 0;
            //这里要做的应该是去遍历一遍数组去找到有多少个在中间区间
            for (int Rindex = 0; Rindex < nums.length ; Rindex++) {
                //只要右边的index值-左边的index的值，那么左边到右边这一段距离都满足
                //if(nums[Rindex]-nums[Lindex]<=mid) count += Rindex-Lindex;
                //上面这一步应该写在下面，如果在上面的话，当Lindex++满足条件的时候回少判断一步
                while(nums[Rindex]-nums[Lindex]>mid&&Lindex<nums.length) Lindex++;
                //写在下面即可
                count += Rindex-Lindex;
            }
            if (count>=k){
                right = mid;
            }else left = mid+1;
        }
        return left;

    }
}
