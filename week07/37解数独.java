package week07.leetcode.editor.cn;
 
//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 哈希表 回溯算法 
// 👍 842 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] row = new int[9];
    int[] col = new int[9];
    int[] box = new int[9];
    List<int[]> space = new ArrayList<int[]>();
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        for(int i = 0;i<9;i++){
            for (int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    space.add(new int[]{i,j});
                }
                else{
                    int num = board[i][j] - '1';
                    helper(num,i,j);
                }
            }
        }
        backTrace(board,0);
    }

    public void backTrace(char[][] board,int step){
        if(step == space.size()){
            valid = true;
            return;
        }
        int i = space.get(step)[0],j = space.get(step)[1];
        int available = ((1 << 9) - 1) & (~(row[i] | col[j] | box[(i / 3) * 3 + j / 3]));
        while(available != 0 && !valid){
            int pos = available & (-available);
            int num = Integer.bitCount(pos - 1);
            available = available & (available - 1);
            board[i][j] = (char)(num + '1');
            helper(num,i,j);
            backTrace(board,step + 1);
            helper(num,i,j);
        }
    }

    public void helper(int num,int i,int j){
        row[i] ^= (1 << num);
        col[j] ^= (1 << num);
        box[(i / 3) * 3 + j / 3] ^= (1 << num);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
