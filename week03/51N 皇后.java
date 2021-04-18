package week03.leetcode.editor.cn;
 
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
// 👍 837 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.回溯+集合
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<List<String>>();
//        int[] queues = new int[n];
//        Arrays.fill(queues,-1);
//        Set<Integer> col = new HashSet<Integer>();
//        Set<Integer> diagonal1 = new HashSet<Integer>();
//        Set<Integer> diagonal2 = new HashSet<Integer>();
//        backTrace(0,n,queues,col,diagonal1,diagonal2,res);
//        return res;
//    }
//
//    public void backTrace(int row,int n,int[] queues,Set<Integer> col,Set<Integer> diagonal1,Set<Integer> diagonal2,List<List<String>> res){
//        if(row == n){
//            res.add(generate(queues));
//            return;
//        }
//        for(int i = 0;i<n;i++){
//            if(col.contains(i)){
//                continue;
//            }
//            int d1 = row - i;
//            if(diagonal1.contains(d1)){
//                continue;
//            }
//            int d2 = row + i;
//            if(diagonal2.contains(d2)){
//                continue;
//            }
//            queues[row] = i;
//            col.add(i);
//            diagonal1.add(d1);
//            diagonal2.add(d2);
//            backTrace(row + 1,n,queues,col,diagonal1,diagonal2,res);
//            queues[row] = -1;
//            col.remove(i);
//            diagonal1.remove(d1);
//            diagonal2.remove(d2);
//        }
//    }
//
//    public List<String> generate(int[] queues){
//        List<String> res = new ArrayList<String>();
//        for(int col:queues){
//            char[] ch = new char[queues.length];
//            Arrays.fill(ch,'.');
//            ch[col] = 'Q';
//            res.add(new String(ch));
//        }
//        return res;
//    }

    //回溯 + 位运算
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queues = new int[n];
        Arrays.fill(queues,-1);
        backTrace(0,n,queues,0,0,0,res);
        return res;
    }

    public void backTrace(int row,int n,int[] queues,int col,int diagonal1,int diagonal2,List<List<String>> res){
        if(row == n){
            res.add(generate(queues));
            return;
        }
        //当前行所有可用位置
        int available = ((1 << n) - 1) & (~(col | diagonal1 | diagonal2));
        while (available != 0){
            int pos = available & (-available);//找到最低位的1（从左到右下一个待插入位置）并把其他位置的值都置0
            available = available & (available - 1);//将最低位1置0
            int c = Integer.bitCount(pos - 1);//待插入位置后面有多少位 即待插入位置下标
            queues[row] = c;
            backTrace(row + 1,n,queues,col | pos,(diagonal1 | pos) << 1,(diagonal2 | pos) >> 1,res);
            queues[row] = -1;
        }
    }

    public List<String> generate(int[] queues){
        List<String> res = new ArrayList<String>();
        for(int col:queues){
            char[] ch = new char[queues.length];
            Arrays.fill(ch,'.');
            ch[col] = 'Q';
            res.add(new String(ch));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
