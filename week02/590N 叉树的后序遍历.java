package leetcode.leetcode.editor.cn;
 
//给定一个 N 叉树，返回其节点值的 后序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 树 
// 👍 138 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //1.递归
//    public List<Integer> postorder(Node root) {
//        List<Integer> res = new ArrayList<Integer>();
//        helper(root,res);
//        return res;
//    }
//
//    public void helper(Node node,List<Integer> list){
//        if(node == null){
//            return;
//        }
//        if(node.children != null){
//            for(Node child : node.children){
//                helper(child,list);
//            }
//        }
//        list.add(node.val);
//    }

    //2.迭代
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null){
            return res;
        }
        Deque<Node> stack = new LinkedList<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.offerFirst(node.val);
            for(Node child : node.children){
                if(child != null){
                    stack.push(child);
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
