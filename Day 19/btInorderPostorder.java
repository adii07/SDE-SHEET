/**Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
*/
class Solution {
    HashMap<Integer,Integer>map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        for(int node=0;node<inorder.length;node++)map.put(inorder[node],node);
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder,int[] postorder,int inorderStart,int inorderEnd,int postorderStart,int postorderEnd){
        if(inorderStart>inorderEnd || postorderStart>postorderEnd) return null;
        TreeNode root=new TreeNode(postorder[postorderEnd]);
        int nodePos=map.get(root.val);
        int nodesToLeft=nodePos-inorderStart;
        root.left=helper(inorder,postorder,inorderStart,nodePos-1,postorderStart,nodesToLeft+postorderStart-1);
        root.right=helper(inorder,postorder,nodePos+1,inorderEnd,postorderStart+nodesToLeft,postorderEnd-1);
        return root;
    }
}