package week05_06.leetcode.editor.cn;
 
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 573 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.中心扩展
//    public int countSubstrings(String s) {
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//        int n = s.length();
//        int res = 0;
//        for(int i = 0;i < 2 * n - 1;i++){
//            int left = i/2,right = i / 2 + i % 2;
//            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
//                res ++;
//                left --;
//                right ++;
//            }
//        }
//        return res;
//    }

    //2.动态规划
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        boolean[] dp = new boolean[n];
        int res = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j<=i;j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1])){
                    res ++;
                    dp[j] = true;
                }
                else {
                    dp[j] = false;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
