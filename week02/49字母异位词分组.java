package leetcode.leetcode.editor.cn;
 
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 713 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.计数
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> map = new HashMap<String, List<String>>();
//        for(String str : strs){
//            int[] count = new int[26];
//            for(int i = 0;i<str.length();i++){
//                count[str.charAt(i) - 'a'] ++;
//            }
//            StringBuffer sb = new StringBuffer();
//            for(int i = 0;i<26;i++){
//                if(count[i] != 0){
//                    sb.append((char)(i + 'a'));
//                    sb.append(count[i]);
//                }
//            }
//            String key = sb.toString();
//            List<String> list = map.getOrDefault(key,new ArrayList<String>());
//            list.add(str);
//            map.put(key,list);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }

    //2.排序
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
