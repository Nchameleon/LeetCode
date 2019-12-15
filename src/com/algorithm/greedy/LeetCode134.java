package com.algorithm.greedy;

/*
 *   加油站问题
 *   Create by 刘文月 on 2019/12/2
 */


public class LeetCode134 {
    //应该是从零开始,如果不能到下一站,就从下一站在开始.
    //最后一个是统计一下,gas和cost的差值是否是大于0.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //开始的坐标
        int start = 0;
        //这是当前的油量
        int curr_tank = 0;
        //总的差值
        int total_gas = 0;
        for (int i = 0;i<gas.length;i++){
            curr_tank += gas[i] - cost[i];
            total_gas += gas[i] - cost[i];
            //如果小于零表明不能够到达下一站,start从当前的下一个位置开始
            if (curr_tank < 0){
                //这里为什么不从i开始,因为curr_tank在加上了当前站的值之后小于零,这表明i站肯定是不能到达下一站的
                start = i + 1 ;
                curr_tank = 0;
            }
        }


        return total_gas>0?start:-1;
    }

}
