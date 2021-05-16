package week05_06.leetcode.editor.cn;
 
//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 二分查找 动态规划 
// 👍 482 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.动态规划
//    public int splitArray(int[] nums, int m) {
//        int n = nums.length;
//        int[][] dp = new int[n + 1][m + 1];
//        for(int i = 0;i<=n;i++){
//            Arrays.fill(dp[i],Integer.MAX_VALUE);
//        }
//        dp[0][0] = 0;
//        int[] sum = new int[n + 1];
//        for(int i = 0;i<n;i++){
//            sum[i + 1] = sum[i] + nums[i];
//        }
//        for(int i = 1;i<=n;i++){
//            for(int j = 1;j<=Math.min(m,i);j++){
//                for(int k = 0;k<i;k++){
//                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[k][j - 1],sum[i] - sum[k]));
//                }
//            }
//        }
//        return dp[n][m];
//    }

    //2.二分查找
    public int splitArray(int[] nums, int m) {
        int left = 0,right = 0;
        for(int num : nums){
            left = Math.max(left,num);
            right += num;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(check(nums,m,mid)){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        return right;
    }

    public boolean check(int[] nums,int m,int sum){
        int cnt = 1,curSum = 0;
        for(int i = 0;i<nums.length;i++){
            if(curSum + nums[i] > sum){
                cnt ++;
                curSum = 0;
            }
            curSum += nums[i];
        }
        return cnt <= m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
