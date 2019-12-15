package com.algorithm.search;

/**
 * @author 刘文月
 * @version 1.0
 * @date 2019/12/9
 */
public class KthSmallestNumber {
    /*
     * 讲真的这题思路是简单，但是有点奇怪，总的来说还是查找。
     * 要查找第k小的数，我们要知道一个范围，给出最小的数和最大的值是很容易知道的，判断第k小的值在中间值得左边还
     * 是右边，然后更新最大或者最小的值，直到最大和最小的数是一个值。ok
     * */
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = getCount(matrix, row, col, mid);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    private int getCount(int[][] matrix, int row, int col, int mid) {
        int count = 0;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] > mid) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}
