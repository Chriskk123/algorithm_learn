package week05_06.leetcode.editor.cn;
 
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 764 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1
//    public int maximalSquare(char[][] matrix) {
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
//            return 0;
//        }
//        int res = 0;
//        int m = matrix.length,n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        for(int i = 0;i<m;i++){
//            for(int j = 0;j<n;j++){
//                if(matrix[i][j] == '1'){
//                    if(i == 0 || j == 0){
//                        dp[i][j] = 1;
//                    }
//                    else{
//                        dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
//                    }
//                    res = Math.max(res,dp[i][j]);
//                }
//            }
//        }
//        return res * res;
//    }

    //2.空间优化
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int res = 0;
        int m = matrix.length,n = matrix[0].length;
        int[] dp = new int[n];
        int temp = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int curTemp = dp[j];//记录未修改前的dp值 供下个j（j + 1）使用（相当于（i - 1，j - 1）位置）
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[j] = 1;
                    }
                    else{
                        dp[j] = Math.min(dp[j - 1],Math.min(dp[j],temp)) + 1;
                    }
                    res = Math.max(res,dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                temp = curTemp;
            }
        }
        return res * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
