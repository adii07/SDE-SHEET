/**Maximum Width of Binary Tree at each level

Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
It is guaranteed that the answer will in the range of 32-bit signed integer. 

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
*/

/**Solution1: Level order traversal

If Parent node has a index idx, then:
    ->Left child has a index 2*idx+1
    ->Right child has a index 2*idx+2
This is done in order to eradicate any possibility of a negative index

Traverse the tree level wise using a queue
At each level mark the 1st node(leftmost node) and subtract it with the last Node(rightmost node) or every subsequent node
Store the max differnce of each node as the ans. 
*/
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int left=q.peek().lvl;
            while(size-->0){
                Pair top=q.remove();
                int tmp=top.lvl-left+1;
                // System.out.println(tmp);
                ans=Math.max(ans,tmp);
                if(top.node.left!=null) q.add(new Pair(top.node.left,2*top.lvl+1));
                if(top.node.right!=null) q.add(new Pair(top.node.right,2*top.lvl+2));
            }
        }
        return ans;
    }
}
class Pair{
    int lvl;
    TreeNode node;
    Pair(TreeNode node, int lvl){
        this.node=node;
        this.lvl=lvl;
    }
}