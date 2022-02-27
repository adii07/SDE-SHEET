/**Balanced Binary Tree
*Given a binary tree, determine if it is height-balanced.
*For this problem, a height-balanced binary tree is defined as:
    A binary tree in which the left and right subtrees of every node differ in height by no more than 1. 
*/

/** Solution : Pair ans DFS

-> A tree can be only on and only if:
    -The absolute difference of it's left and right subtree height is 1
    -It's left subtree is balanced 
    -It's right subtree is balanced 
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        Pair ans=helper(root);
        return ans.isBalanced;
    }
    
    public Pair helper(TreeNode root){
        if(root==null) return new Pair(0,true);
        
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        Pair val=new Pair();
        val.height=Math.max(left.height,right.height)+1;
        val.isBalanced=false;
        if(Math.abs(left.height-right.height)<=1 && left.isBalanced && right.isBalanced)
            val.isBalanced=true;
        
        return val;
    }
}
class Pair{
    int height;
    boolean isBalanced;
    Pair(){}
    Pair(int heigth,boolean isBalanced){
        this.height=height;
        this.isBalanced=isBalanced;
    }
}