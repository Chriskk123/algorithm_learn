package leetcode.leetcode.editor.cn;
 
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 366 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.数组计数
//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        //由于只包括小写字母 可以用数组代替map
//        int[] count = new int[26];
//        for(int i = 0;i<s.length();i++){
//            count[s.charAt(i) - 'a'] ++;
//        }
//        for(int i = 0;i<t.length();i++){
//            if(--count[t.charAt(i) - 'a'] < 0){
//                return false;
//            }
//        }
//        return true;
//    }

    //2.哈希表
//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        char[] sChar = s.toCharArray();
//        char[] tChar = t.toCharArray();
//        Map<Character,Integer> map = new HashMap<Character, Integer>();
//        for(char ch : sChar){
//            map.put(ch,map.getOrDefault(ch,0) + 1);
//        }
//        for(char ch : tChar){
//            map.put(ch,map.getOrDefault(ch,0) - 1);
//            if(map.get(ch) < 0){
//                return false;
//            }
//        }
//        return true;
//    }

    //3.排序
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar,tChar);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
