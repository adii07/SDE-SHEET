/**Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/

/**Solution 1:
->Check if the root value is greater than both q and p if yes ans is present in the left subtree
->Check if the root value is smaller than both q and p if yes ans is present in the right subtree
->Else either root lies on either(smaller and greater) side making the root the lca.
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}