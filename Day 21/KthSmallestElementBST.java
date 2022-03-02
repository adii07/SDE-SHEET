/**Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/

/**Solution 1 */
class Solution {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null || k<0) return -1;
        int val=kthSmallest(root.left,k);
        if(val!=-1) return val;
        count++;
        if(k==count) return root.val;
        val=kthSmallest(root.right,k);
        return val;
    }
}

/**Solution 2 */
class Solution {
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(root.right, k);       
    }
}

/**Solution 3 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<Pair> q=new Stack<>();
        q.push(new Pair(root,0));
        while(!q.isEmpty()){
            Pair head=q.pop();
            if(head.order==0){
                q.push(new Pair(head.node,1));
                if(head.node.left!=null){
                    q.push(new Pair(head.node.left,0));
                }
            }
            else if(head.order==1){
                k--;
                if(k==0) return head.node.val;
                if(head.node.right!=null){
                    q.push(new Pair(head.node.right,0));
                }
            }
        }
        return -1;
    }
}
class Pair{
    TreeNode node;
    int order;
    /**
    *0->preorder
    *1->inorder
    *2->postorder
    */
    Pair(TreeNode node,int order){
        this.node=node;
        this.order=order;
    }
}