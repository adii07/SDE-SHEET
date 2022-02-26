/**Binary Tree Postorder Traversal
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1] 
*/

/**Solution 1: Recursion */
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return ans;
        helper(root);
        return ans;
    }
    public void helper(TreeNode node){
        if(node==null)return;
        helper(node.left);
        helper(node.right);
        ans.add(node.val);
    }
} 