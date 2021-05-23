package week07.leetcode.editor.cn;
 
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
// 👍 880 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queues = new int[n];
        Arrays.fill(queues,-1);
        backTrace(queues,res,n,0,0,0,0);
        return res;
    }

    public void backTrace(int[] queues,List<List<String>>res,int n,int col,int diagonal0,int diagonal1,int row){
        if(row == n){
            res.add(generateRes(queues));
            return;
        }
        int available = ((1 << n) - 1) & (~(col | diagonal0 | diagonal1));
        while(available != 0){
            int pos = available & (-available);
            available = available & (available - 1);
            int c = Integer.bitCount(pos - 1);
            queues[row] = c;
            backTrace(queues,res,n,col | pos,(diagonal0 | pos) >> 1,(diagonal1 | pos) << 1,row + 1);
            queues[row] = -1;
        }
    }

    public List<String> generateRes(int[] queues){
        List<String> ans = new ArrayList<String>();
        int n = queues.length;
        char[] ch = new char[n];
        Arrays.fill(ch,'.');
        for(int col : queues){
            ch[col] = 'Q';
            ans.add(new String(ch));
            ch[col] = '.';
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
