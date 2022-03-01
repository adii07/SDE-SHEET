/**Validate Binary Search Tree
*Given the root of a binary tree, determine if it is a valid binary search tree (BST).

*A valid BST is defined as follows:
    ->The left subtree of a node contains only nodes with keys less than the node's key.
    ->The right subtree of a node contains only nodes with keys greater than the node's key.
    ->Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/
/**Solution:
->While making a check we want to consider the max from the left subtree and the min from the right subtree
->For a tree to be valid bst not only does :
    ->it's left child should be smaller than it
    ->it's right child should be greater than it
    ->it's left and right subtrees shols be a valid bst as well
    ->Root value must be greater than the max of left subtree and 
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null); 
        
    }
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root==null) return true;
        if(min!=null && root.val<=min.val) return false;
        if(max!=null && root.val>=max.val) return false;
        if(!isValidBST(root.left, min, root)) return false;
        if(!isValidBST(root.right, root, max)) return false;
        return true;
    }
}