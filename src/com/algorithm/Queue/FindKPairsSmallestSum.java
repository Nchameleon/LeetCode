package com.algorithm.Queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/12
 */
public class FindKPairsSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //感觉利用了最小堆，这题还是时间复杂度很高
        List<List<Integer>> list = new ArrayList<>();
        if (nums1.length == 0||nums2.length ==0||k==0) return list;
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(k,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]+o1[1])-(o2[0]+o2[1]);
            }
        });
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j <nums2.length ; j++) {
                int[] arr = new int[]{nums1[i],nums2[j]};
                pqueue.add(arr);
            }
        }
        while(k>0){
            if (pqueue.isEmpty()) break;
            List<Integer> list1 = new ArrayList<>();
            int[] poll = pqueue.poll();
            list1.add(poll[0]);
            list1.add(poll[1]);
            list.add(list1);

        }
        return list;
    }
}
