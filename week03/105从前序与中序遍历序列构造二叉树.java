package week03.leetcode.editor.cn;
 
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 992 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIdx = 0;
        for(int i = 1;i<preorder.length;i++){
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inorderIdx]){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }
            else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIdx]){
                    node = stack.pop();
                    inorderIdx ++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
