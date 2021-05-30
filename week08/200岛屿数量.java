package week08.leetcode.editor.cn;
 
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1168 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dx = new int[]{0,-1,0,1};
    int[] dy = new int[]{-1,0,1,0};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    res ++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }

    public void dfs(int i,int j,char[][] grid){
        grid[i][j] = '0';
        for(int k = 0;k<4;k++){
            int x = i + dx[k],y = j + dy[k];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
                continue;
            }
            dfs(x,y,grid);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
