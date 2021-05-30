package week08.leetcode.editor.cn;
 
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// 👍 262 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int mask;
    private int res;
    public int totalNQueens(int n) {
        mask = (1 << n) - 1;
        dfs(0,0,0);
        return res;
    }

    public void dfs(int col,int diagonal1,int diagonal2){
        if(col == mask){//每一列都放置了皇后 执行结束 获得一个可行方案
            res ++;
            return;
        }
        int available = mask & (~(col | diagonal1 | diagonal2));
        while(available != 0){
            int pos = available & (-available);
            available &= available - 1;
            dfs(col | pos,(diagonal1 | pos) << 1,(diagonal2 | pos) >> 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
