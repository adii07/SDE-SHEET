/**Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
*/

/**Solution 1: Recursion */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null) return false;
        
        return (root1.val==root2.val)&&helper(root1.left,root2.right)&&helper(root1.right,root2.left); 
    }
}

/**Solution 2: Iterative solution using Queue or Stack*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(q.size()!=0){
            TreeNode left=q.remove();
            TreeNode right=q.remove();
            if(left==null && right==null) continue;
            else if(left==null || right==null || left.val!=right.val) return false;
            
            q.add(left.left);q.add(right.right);
            q.add(left.right);q.add(right.left);
            
        }
        return true;
    }
    
}