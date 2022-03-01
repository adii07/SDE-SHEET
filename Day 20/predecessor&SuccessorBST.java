/**Predecessor And Successor In BST

You have been given a binary search tree of integers with ‘N’ nodes. You are also given 'KEY' which represents data of a node of this tree. Your task is to find the predecessor and successor of the given node in the BST.
Note:
1. The predecessor of a node in BST is that node that will be visited just before the given node in the inorder traversal of the tree. If the given node is visited first in the inorder traversal, then its predecessor is NULL.
2. The successor of a node in BST is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its successor is NULL.
3. The node for which predecessor and successor are to be found will always be present in the given tree.
4. A binary search tree (BST) is a binary tree data structure which has the following properties.
     • The left subtree of a node contains only nodes with data less than the node’s data.
     • The right subtree of a node contains only nodes with data greater than the node’s data.
     • Both the left and right subtrees must also be binary search trees.
Sample Input 1:
1
15 10 20 8 12 16 25 -1 -1 -1 -1 -1 -1 -1 -1
10
Sample Output 1:
8 12
Sample Input 2:
2 
10 5 -1 -1 -1 -1
5
20 -1 -1
20
Sample Output 2:
-1 10
-1 -1
*/


/**Solution 1: Store the inorder and return the left(n-1) and the right(n+1) value of the key(n)*/

/**Solution 2:iterate over the tree to get the desired result
->For the successor the value has to be just greater than the key,therefore:
    ->If the value at the root is less than or equal to the key value move to the right child where all the values are greater than the current root
    ->If the value at root is grater than the key value store it at as the cuurent successor and move to it's left, as values to the left are bound to be smaller than the current root value
->For the predecessor the value has to be just smaller than the key,therefore:
    ->If the value at the root is greater than or equal to the key value move to the left child where all the values are smaller than the current root
    ->If the value at the root is less than the key value move to the right child where all the values are greater than the current root(we have to find the just greater value)
*/
import java.util.ArrayList;
public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
        ArrayList<Integer> ans=new ArrayList<>();
        int a=successor(root,key);
        int b=predecessor(root,key);
        ans.add(b);
        ans.add(a);
        return ans;
	}
    public static int successor(BinaryTreeNode<Integer> root, int key){
        int ans=-1;
       while(root!=null){
           if(root.data<=new Integer(key)){
               root=root.right;
           }else{
               ans=new Integer(root.data);
               root=root.left;
           }
       }
        return ans;
    }
    public static int predecessor(BinaryTreeNode<Integer> root, int key){
       int ans=-1;
       while(root!=null){
           if(root.data>=new Integer(key)){
               root=root.left;
           }else{
               ans=new Integer(root.data);
               root=root.right;
           }
       }
        return ans;
    }
}
/*************************************************************
    Following is the Binary Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/
