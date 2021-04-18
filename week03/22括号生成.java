package week03.leetcode.editor.cn;
 
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1725 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(0,0,n,new StringBuilder(),res);
        return res;
    }

    public void generate(int left,int right,int num,StringBuilder str,List<String> res){
        if(right == num){
            res.add(str.toString());
            return;
        }
        if(left < num){
            str.append('(');
            generate(left + 1,right,num,str,res);
            str.deleteCharAt(str.length() - 1);
        }
        if(right < left){
            str.append(')');
            generate(left,right + 1,num,str,res);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
