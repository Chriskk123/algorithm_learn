package leetcode.leetcode.editor.cn;
 
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2219 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
    //1.双指针动态规划
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3){
            return 0;
        }
        int left = 0,right = n - 1;
        int leftMax = 0,rightMax = 0;
        int res = 0;
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(height[left] < height[right]){
                res += leftMax - height[left++];
            }
            else{
                res += rightMax - height[right--];
            }
        }
        return res;
    }
}

    //2.单调栈
//class Solution {
//    public int trap(int[] height) {
//        int n = height.length;
//        if(n < 3){
//            return 0;
//        }
//        Deque<Integer> stack= new LinkedList<Integer>();
//        int res = 0;
//        for(int i = 0;i<n;i++){
//            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
//                int top = stack.pop();
//                if(stack.isEmpty()){
//                    break;
//                }
//                int left = stack.peek();
//                int w = i - left - 1;
//                int h = Math.min(height[left],height[i]) - height[top];
//                res += w * h;
//            }
//            stack.push(i);
//        }
//        return res;
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)

}