package week07.leetcode.editor.cn;
 
//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 
// 👍 102 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    //1.BFS
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        if(grid == null || grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1){
//            return -1;
//        }
//        int n = grid.length;
//        if(n <= 2){
//            return n;
//        }
//        int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
//        int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};
//        Deque<int[]> queue = new LinkedList<int[]>();
//        grid[0][0] = 1;
//        queue.offer(new int[]{0,0,1});//{i,j,step}
//        while (!queue.isEmpty()){
//            int[] node = queue.poll();
//            int i = node[0],j = node[1],step = node[2];
//            for(int k = 0;k<8;k++){
//                int x = i + dx[k],y = j + dy[k];
//                if(x == n - 1 && y == n - 1){
//                    return step + 1;
//                }
//                if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0){
//                    queue.offer(new int[]{x,y,step +1});
//                    grid[x][y] = 1;//set visited
//                }
//            }
//        }
//        return -1;
//    }

    //2.A*
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1){
            return -1;
        }
        int n = grid.length;
        if(n <= 2){
            return n;
        }
        int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) ->(a[0] - b[0]));
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0,0,0,1});//{h,i,j,step}
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int i = node[1],j = node[2],step = node[3];
            if(visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            for(int k = 0;k<8;k++){
                int x = i + dx[k],y = j + dy[k];
                if(x == n - 1 && y == n - 1){
                    return step + 1;
                }
                if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0){
                    queue.offer(new int[]{step + heuristic(x,y,n),x,y,step +1});
                }
            }
        }
        return -1;
    }

    public int heuristic(int x,int y,int n){
        return Math.max(Math.abs(n - 1 - x),Math.abs(n - 1 - y));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
