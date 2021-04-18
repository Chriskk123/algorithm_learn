package week03.leetcode.editor.cn;
 
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1296 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int num : nums){
            ans.add(num);
        }
        backTrace(res,ans,0,nums.length);
        return res;
    }

    public void backTrace(List<List<Integer>> res,List<Integer> ans,int start,int n){
        if(start == n){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start;i<n;i++){
            Collections.swap(ans,start,i);
            backTrace(res,ans,start + 1,n);
            Collections.swap(ans,start,i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
