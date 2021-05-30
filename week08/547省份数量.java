package week08.leetcode.editor.cn;
 
//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 557 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.dfs
//    public int findCircleNum(int[][] isConnected) {
//        if(isConnected == null || isConnected.length == 0 || isConnected[0].length == 0){
//            return 0;
//        }
//        int n = isConnected.length;
//        int res = 0;
//        boolean[] visited = new boolean[n];
//        for(int i = 0;i<n;i++){
//            if(!visited[i]){
//                res ++;
//                dfs(i,isConnected,visited);
//            }
//        }
//        return res;
//    }
//
//    public void dfs(int i,int[][] isConnected,boolean[] visited){
//        visited[i] = true;
//        for(int j = 0;j<isConnected[i].length;j++){
//            if(!visited[j] && isConnected[i][j] == 1){
//                dfs(j,isConnected,visited);
//            }
//        }
//    }

    //2.并查集
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0 || isConnected[0].length == 0){
            return 0;
        }
        int n = isConnected.length;
        int res = 0;
        int[] parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        for(int i = 0;i<n - 1;i++){
            for(int j = i + 1;j<n;j++){
                if(isConnected[i][j] == 1){
                    union(parent,i,j);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(parent[i] == i){
                res ++;
            }
        }
        return res;
    }

    public void union(int[] parent,int i,int j){
        parent[findParent(parent,i)] = findParent(parent,j);
    }

    public int findParent(int[] parent,int i){
        if(parent[i] != i){
            parent[i] = findParent(parent,parent[i]);
        }
        return parent[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
