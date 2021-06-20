package week10.leetcode.editor.cn;
 
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 399 👎 0

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //1.哈希表
//    public int firstUniqChar(String s) {
//        if(s == null || s.length() == 0){
//            return -1;
//        }
//        Map<Character,Integer> map = new HashMap<Character, Integer>();
//        char[] chs = s.toCharArray();
//        for(char ch : chs){
//            map.put(ch,map.getOrDefault(ch,0) + 1);
//        }
//        for(int i = 0;i< chs.length;i++){
//            if(map.get(chs[i]) == 1){
//                return i;
//            }
//        }
//        return -1;
//    }

    //2.数组
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        int[] cnt = new int[26];
        for(int i = 0;i< s.length();i++){
            cnt[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0;i<s.length();i++){
            if(cnt[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
