package leetcode.leetcode.editor.cn;
 
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 147 👎 0


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.小顶堆
    public int nthUglyNumber(int n) {
        int[] factors = new int[]{2,3,5};
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        set.add(1L);
        heap.offer(1L);
        int res = 0;
        for(int i = 0;i<n;i++){
            long min = heap.poll();
            res = (int) min;
            for(int f : factors){
                long next = min * f;
                if(set.add(next)){
                    heap.offer(next);
                }
            }
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
