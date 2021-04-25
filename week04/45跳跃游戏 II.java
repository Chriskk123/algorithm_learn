package week04.leetcode.editor.cn;
 
//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 934 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //1.
//    public int jump(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return -1;
//        }
//        int n = nums.length;
//        if(n == 1){
//            return 0;
//        }
//        int res = 0;
//        int maxIdx = 0;
//        for(int i = 0;i<n;){
//            int max = maxIdx;
//            while (i <= max){
//                maxIdx = Math.max(maxIdx,nums[i] + i);
//                i++;
//            }
//            res ++;
//            if(maxIdx >= n - 1){
//                return res;
//            }
//        }
//        return n - 1;
//    }

    //2.
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int res = 0;
        int maxIdx = 0;
        for(int i = 0;i<n;){
            if(maxIdx >= n - 1){//法二与法一的区别主要在于这个判断语句的先后，将此语句提前则不需要额外判断n为1的情况
                return res;
            }
            int max = maxIdx;
            while (i <= max){
                maxIdx = Math.max(maxIdx,nums[i] + i);
                i++;
            }
            res ++;
        }
        return n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
