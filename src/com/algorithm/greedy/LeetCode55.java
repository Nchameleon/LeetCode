package com.algorithm.greedy;

/*
 *
 *   Create by 刘文月 on 2019/12/1
 */

/*
* 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。
* */

public class LeetCode55 {

    public boolean canJump(int[] nums) {
        //目标是只要能够到达最后一个点就行了,设置一个值表示当前能够到达的位置
        int temp = 0;
        for (int i = 0 ; i<nums.length;i++){
            temp = Math.max(i+nums[i],temp);
            if(temp>=nums.length-1) return true;
            //这句话表示的是在走到最后一个点之前最大只能走到前面的一个点
            if (temp == i) return false;

        }
        return false;
    }


}
