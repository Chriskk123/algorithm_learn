package week08.leetcode.editor.cn;
 
//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 393 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dx = new int[]{0,-1,0,1};
    int[] dy = new int[]{-1,0,1,0};
    char[][] board;
    List<String> res = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
            return res;
        }
        this.board = board;
        Trie root = new Trie();
        for(String word : words){
            Trie node = root;
            for(char ch : word.toCharArray()){
                if(node.children.containsKey(ch)){
                    node = node.children.get(ch);
                }
                else{
                    Trie newNode = new Trie();
                    node.children.put(ch,newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        for(int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if(root.children.containsKey(board[i][j])){
                    dfs(i,j,root);
                }
            }
        }
        return res;
    }

    public void dfs(int i,int j,Trie node){
        char ch = board[i][j];
        Trie curNode = node.children.get(ch);
        if(curNode.word != null){
            res.add(curNode.word);
            curNode.word = null;
        }
        board[i][j] = '#';
        int m = board.length,n = board[0].length;
        for(int k = 0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x < 0 || x >= m || y < 0 || y >= n){
                continue;
            }
            if(curNode.children.containsKey(board[x][y])){
                dfs(x,y,curNode);
            }
        }
        board[i][j] = ch;
        if(curNode.children.isEmpty()){
            node.children.remove(ch);
        }
    }
}

class Trie{
    HashMap<Character,Trie> children = new HashMap<Character, Trie>();
    String word = null;
    public Trie(){}
}
//leetcode submit region end(Prohibit modification and deletion)
