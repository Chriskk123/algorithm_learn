package week03.leetcode.editor.cn;
 
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 673 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        backTrace(res,ans,0,visited,nums);
        return res;
    }

    public void backTrace(List<List<Integer>> res,List<Integer> ans,int start,boolean[] visited,int[] nums){
        if(start == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])){
                continue;
            }
            ans.add(nums[i]);
            visited[i] = true;
            backTrace(res,ans,start + 1,visited,nums);
            ans.remove(start);
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
