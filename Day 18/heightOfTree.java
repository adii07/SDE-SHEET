/**Maximum Depth of Binary Tree // Height of Binary Tree 
->Height of a node is the mex of the heoght if left child or right child +1(it's own height)*/

public int maxDepth(TreeNode root) {
    if(root==null) return 0;    
    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        
}