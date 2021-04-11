package leetcode.leetcode.editor.cn;
 
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 948 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.双端队列
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if(n == 0 || k == 0){
//            return new int[0];
//        }
//        Deque<Integer> queue = new LinkedList<Integer>();
//        int[] res = new int[n - k + 1];
//        for(int i = 0;i<k;i++){
//            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
//                queue.pollLast();
//            }
//            queue.offerLast(nums[i]);
//        }
//        res[0] = queue.peekFirst();
//        for(int i = k;i<n;i++){
//            if(queue.peekFirst() == nums[i - k]){
//                queue.pollFirst();
//            }
//            while(!queue.isEmpty() && queue.peekLast() < nums[i]){
//                queue.pollLast();
//            }
//            queue.offerLast(nums[i]);
//            res[i - k + 1] = queue.peekFirst();
//        }
//        return res;
//    }

    //2.堆
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0){
            return new int[0];
        }
        //大顶堆中存入二元组（数值，下标）
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> (a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]));
        int[] res = new int[n - k + 1];
        //初始化堆 将前k个元素加入堆
        for(int i = 0;i<k;i++){
            heap.offer(new int[]{nums[i],i});
        }
        res[0] = heap.peek()[0];
        for(int i = k;i<n;i++){
            //(1) (2)顺序不能调 不然可能回报空指针错误（由于2比较前没判堆是否为空）
            heap.offer(new int[]{nums[i],i});//(1)
            //判断最大值元素下标是否在滑动窗口对应下标范围内 否则弹出元素 直到最大值元素下标满足条件
            while(heap.peek()[1] <= i - k){//(2)
                heap.poll();
            }
            res[i - k + 1] = heap.peek()[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
