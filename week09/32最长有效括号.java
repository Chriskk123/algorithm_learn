package week09.leetcode.editor.cn;
 
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1329 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for(int i = 1;i<n;i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                }
                else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
