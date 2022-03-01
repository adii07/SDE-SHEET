/**Check for Children Sum Property in a Binary Tree
Problem Statement: 
Children Sum Property in a Binary Tree. Write a program that converts any binary tree to one that follows the children sum property.

The children sum property is defined as, For every node of the tree, the value of a node is equal to the sum of values of its children(left child and right child).

Note: 
*The node values can be increased by 1 any number of times but decrement of any node value is not allowed.
*A value for a NULL node can be assumed as 0.
*You are not allowed to change the structure of the given binary tree.
Example
1
2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 
Valid ( One of the possible answers is : 
45 35 10 32 3 8 2 -1 -1 -1 -1 -1, thus if the user modifies the given tree like this, the output printed will be valid).
*/

/**Solution :

->Perform a simple dfs traversal on the tree.
->For the base case, if the node is pointing to NULL,return.
->At every node, first find the sum of values of the children( For a NULL child, value is assumed to be 0).
->If node’s value > sum of children node value,assign both the children’s value to their parent’s node value.
->Then visit the children using recursion.
->Return to the node after visiting its children(in postorder),set its value to be equal to the sum of its values of its children.
*/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root==null) return;
        BinaryTreeNode left=root.left;
        BinaryTreeNode right=root.right;
        int rootValue=new Integer(root.data);
        int childrenSum=0;
        childrenSum+=(root.left==null)?0:new Integer(root.left.data);
        childrenSum+=(root.right==null)?0:new Integer (root.right.data);
        if(childrenSum<rootValue){
            if(root.left!=null)root.left.data=new Integer(rootValue);
            if(root.right!=null)root.right.data=new Integer(rootValue);
        }
        changeTree(root.left);changeTree(root.right);
        childrenSum=0;
        childrenSum+=(root.left==null)?0:new Integer(root.left.data);
        childrenSum+=(root.right==null)?0:new Integer (root.right.data);
        if(root.left!=null || root.right!=null){
            root.data=new Integer(childrenSum);
        }
    }
}

/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/