package week08.leetcode.editor.cn;
 
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 891 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queues = new int[n];
        Arrays.fill(queues,-1);
        dfs(0,0,0,0,n,queues,res);
        return res;
    }

    public void dfs(int col,int diagonal1,int diagonal2,int row,int n,int[] queues,List<List<String>> res){
        if(row == n){
            res.add(parseRes(queues));
            return;
        }
        int available = ((1 << n) - 1) & (~(col | diagonal1 | diagonal2));
        while(available != 0){
            int pos = available & (-available);
            int c = Integer.bitCount(pos - 1);
            queues[row] = c;
            available &= available - 1;
            dfs(col | pos,(diagonal1 | pos) << 1,(diagonal2 | pos) >> 1,row + 1,n,queues,res);
        }
    }

    public List<String> parseRes(int[] queues){
        List<String> ans = new ArrayList<String>();
        char[] ch = new char[queues.length];
        Arrays.fill(ch,'.');
        for(int c : queues){
            ch[c] = 'Q';
            ans.add(new String(ch));
            ch[c] = '.';
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
