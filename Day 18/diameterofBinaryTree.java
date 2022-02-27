/**Diameter of Binary Tree
*Given the root of a binary tree, return the length of the diameter of the tree.
*The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
*The length of a path between two nodes is represented by the number of edges between them. 
NOTE: diamter is calculated by counting the edges not the nodes.Therefore we only use Left.height+Right.height for the diameter of the node not Left.height+Right.height+1
*/

/*Solution : Using Pair to pass along the height and the diamter together
->The diameter either:
    ->Passes through the node(left.height,right.height)
    ->Present in the left subtree(left.diameter)
    ->Present int the right subtree(right.diameter)
*/
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Pair ans=helper(root);
        return ans.diameter;
    }
    public Pair helper(TreeNode root){
        if(root==null){
            Pair tmp=new Pair(0,0);
            return tmp;
        }
        
        Pair val=new Pair(0,0);
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        val.height=Math.max(left.height,right.height)+1;
        val.diameter=Math.max((left.height+right.height),Math.max(left.diameter,right.diameter));
        return val;
    }
}
class Pair{
    int diameter;
    int height;
    Pair(int diameter,int height){
        this.diameter=diameter;
        this.height=height;
    }
}