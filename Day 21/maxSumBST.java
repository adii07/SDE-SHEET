/**Maximum Sum BST in Binary Tree

Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:
    ->The left subtree of a node contains only nodes with keys less than the node's key.
    ->The right subtree of a node contains only nodes with keys greater than the node's key.
    ->Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.

Example 2:
Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.

Example 3:
Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.

Constraints:
The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
*/
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
    public int maxSumBST(TreeNode root) {
        int[] ans=new int[1];
        Pair p=helper(root,ans);
        return ans;
    }
    
    public Pair helper(TreeNode root,int[] ans){
        if(root==null){
            Pair p=new Pair();
            p.isBst=true;p.max=Integer.MIN_VALUE;
            p.min=Integer.MAX_VALUE;int sum=0;
            return p;
        }
        Pair left=helper(root.left,ans);
        Pair right=helper(root.right,ans);
        Pair p=new Pair();
        if(left.isBst && right.isBst && root.val>left.max && root.val<right.min){
            p.isBst=true;
            p.max=Math.max(root.val,Math.max(left.max,right.max));
            p.min=Math.min(root.val,Math.min(left.min,right.min));
            p.sum=root.val+left.sum+right.sum;
            ans[0]=Math.max(ans[0],p.sum);
        }else{
            p.isBst=false;
            p.max=Math.max(root.val,Math.max(left.max,right.max));
            p.min=Math.min(root.val,Math.min(left.min,right.min));
            p.sum=Math.max(left.sum,right.sum);
        }
        return p;
    }
}
class Pair{
    boolean isBst;
    int max;
    int min;
    int sum;
    Pair(){}
}