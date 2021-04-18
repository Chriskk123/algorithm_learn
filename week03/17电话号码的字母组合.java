package week03.leetcode.editor.cn;
 
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1251 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.递归回溯
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        Map<Character,String> map = new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        combine(0,map,new StringBuilder(),digits,res);
        return res;
    }

    public void combine(int i,Map<Character,String> map,StringBuilder str,String digits,List<String> res){
        if(i == digits.length()){
            res.add(str.toString());
            return;
        }
        for(char ch : map.get(digits.charAt(i)).toCharArray()){
            str.append(ch);
            combine(i + 1,map,str,digits,res);
            str.deleteCharAt(i);
        }
    }

    //2.队列
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> res = new LinkedList<String>();
//        if(digits == null || digits.length() == 0){
//            return res;
//        }
//        String [] mapList = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        res.add("");
//        for(int i = 0;i<digits.length();i++){
//            int num = digits.charAt(i) - '0';
//            while(res.peek().length() == i){
//                String str = res.remove();
//                for(char ch : mapList[num].toCharArray()){
//                    res.add(str + ch);
//                }
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
