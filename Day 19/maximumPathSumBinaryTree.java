/**Binary Tree Maximum Path Sum
*A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
*A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
*The path sum of a path is the sum of the node's values in the path.
*Given the root of a binary tree, return the maximum path sum of any non-empty path. 
https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/


/**Solution 1:
->The max path can pass through the root ot not
->Use an int[] instead of int, because int is passed by value as a copy and int[] is passed by refernce(address)
    Therefore int[] will remain contant for each recursion,whereas int will pass a copy in eachrecursion and original ans will remain unchanged
->While considering the max path consider the left+right+root as they are all connnected through the root
->While passing the max only consider the max we only consider the max of left or right as only one of them could be connected to the max path.  
*/
class Solution {
    int maxValue=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        /*
            int left=helper(root.left,ans);
            left=left<0?0:left;
            int right=helper(root.right,ans);
            right=right<0?0:right;
        */
        int leftSub=Math.max(0,helper(root.left));
        int rightSub=Math.max(0,helper(root.right));
        maxValue=Math.max(maxValue,root.val+leftSub+rightSub);
        return Math.max(leftSub,rightSub)+root.val;
    }
}