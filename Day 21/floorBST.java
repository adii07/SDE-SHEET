/**Floor in a BST

Problem Statement
You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. Your task is to find the greatest value node of the BST which is smaller than or equal to ‘X’.
Note :‘X’ is not smaller than the smallest node of BST .

Example:
2
10 5 15 2 6 -1 -1 -1 -1 -1 -1
7
2 1 3 -1 -1 -1 -1
2
Sample Output 1:
6
2
*/

/**Solution: 
->Floor is the value just smaller than than the given value(the greatest amongst the smaller values than X)
->Therefore travel the tree
->If the root value is greater than x we simply move to the left to find the smaller value
->If we encounter a value smaller than or equal to the given key, we mark it as the potential ans and move towards right to find the maximum possible value amongst the smaller values.
*/
public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int ans=X;
        while(root!=null){
            if(root.data>new Integer(X)){
                root=root.left;
            }else{
                ans=root.data;
                root=root.right;
            }
        }
        return ans;
    }
}
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/