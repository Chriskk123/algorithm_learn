package week07.leetcode.editor.cn;
 
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 760 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.BFS
//    HashMap<String,Integer> wordMap = new HashMap<String, Integer>();
//    List<List<Integer>> edges = new ArrayList<List<Integer>>();
//    int wordNum = 0;
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0){
//            return 0;
//        }
//        for(String word : wordList){
//            buildEdge(word);
//        }
//        buildEdge(beginWord);
//        if(!wordMap.containsKey(endWord)){
//            return 0;
//        }
//        int[] cnt = new int[wordNum];
//        Arrays.fill(cnt,Integer.MAX_VALUE);
//        int beginId = wordMap.get(beginWord),endId = wordMap.get(endWord);
//        cnt[beginId] = 0;
//        Deque<Integer> queue = new LinkedList<Integer>();
//        queue.offer(beginId);
//        while (!queue.isEmpty()){
//            int idx = queue.poll();
//            if(idx == endId){
//                return cnt[idx] / 2 + 1;
//            }
//            for(int id : edges.get(idx)){
//                if(cnt[id] == Integer.MAX_VALUE){
//                    cnt[id] = cnt[idx] + 1;
//                    queue.offer(id);
//                }
//            }
//        }
//        return 0;
//    }
//
//    public void buildEdge(String word){
//        buildWord(word);
//        int idx1 = wordMap.get(word);
//        char[] ch = word.toCharArray();
//        for(int i = 0;i<ch.length;i++){
//            char temp = ch[i];
//            ch[i] = '*';
//            String newStr = new String(ch);
//            buildWord(newStr);
//            int idx2 = wordMap.get(newStr);
//            edges.get(idx1).add(idx2);
//            edges.get(idx2).add(idx1);
//            ch[i] = temp;
//        }
//    }
//
//    public void buildWord(String word){
//        if(!wordMap.containsKey(word)){
//            wordMap.put(word,wordNum ++);
//            edges.add(new ArrayList<Integer>());
//        }
//    }

    //2.双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0){
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> beginVisited = new HashSet<String>();
        Set<String> endVisited = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        beginVisited.add(beginWord);
        endVisited.add(endWord);
        int step = 1;
        while (beginVisited.size() > 0 && endVisited.size() > 0){
            if(beginVisited.size() > endVisited.size()){
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            Set<String> levelVisited = new HashSet<String>();
            for(String word : beginVisited){
                if(check(word,visited,levelVisited,endVisited,wordSet)){
                    return step + 1;
                }
            }
            beginVisited = levelVisited;
            step ++;
        }
        return 0;
    }

    public boolean check(String word,Set<String> visited,Set<String> levelVisited,Set<String> endVisited,Set<String> wordSet){
        char[] ch = word.toCharArray();
        for(int i = 0;i<ch.length;i++){
            char temp = ch[i];
            for(int a = 0;a<26;a++){
                ch[i] = (char)(a + 'a');
                if(ch[i] == temp){
                    continue;
                }
                String newWord = new String(ch);
                if(wordSet.contains(newWord)){
                    if(endVisited.contains(newWord)){
                        return true;
                    }
                    if(!visited.contains(newWord)){
                        visited.add(newWord);
                        levelVisited.add(newWord);
                    }
                }
            }
            ch[i] = temp;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
