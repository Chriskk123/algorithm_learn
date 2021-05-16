package week05_06.leetcode.editor.cn;
 
//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 966 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        int res = 0;
        for(int i = 0;i<n;){
            if(maxIdx >= n - 1){
                return res;
            }
            int curMax = maxIdx;
            while(i <= curMax){
                maxIdx = Math.max(maxIdx,i + nums[i++]);
            }
            res ++;
        }
        return n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
