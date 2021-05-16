package week05_06.leetcode.editor.cn;
 
//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。 
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 队列 二分查找 动态规划 
// 👍 326 👎 0

import java.util.Set;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length,n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++){
            int[] sum = new int[n];
            for(int j = i;j<m;j++){
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int cnt = 0;
                for(int col = 0;col<n;col++){
                    sum[col] += matrix[j][col];
                    cnt += sum[col];
                    Integer ceiling = set.ceiling(cnt - k);
                    if(ceiling != null){
                        res = Math.max(res,cnt - ceiling);
                    }
                    set.add(cnt);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
