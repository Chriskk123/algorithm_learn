package week10.leetcode.editor.cn;
 
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 
// 👍 360 👎 0

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.两个哈希表
//    public boolean isIsomorphic(String s, String t) {
//        if(s == null || t == null || s.length() != t.length()){
//            return false;
//        }
//        int n = s.length();
//        Map<Character,Character> map0 = new HashMap<Character, Character>();
//        Map<Character,Character> map1 = new HashMap<Character, Character>();
//        for(int i = 0;i<n;i++){
//            char sChar = s.charAt(i),tChar = t.charAt(i);
//            char temp0 = map0.getOrDefault(sChar,tChar);
//            if(temp0 != tChar){
//                return false;
//            }
//            map0.put(sChar,tChar);
//            char temp1 = map1.getOrDefault(tChar,sChar);
//            if(temp1 != sChar){
//                return false;
//            }
//            map1.put(tChar,sChar);
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        for(int i = 0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
