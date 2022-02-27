/** Boundary Traversal

Problem Statement
You have been given a binary tree of integers. Your task is to print the boundary nodes of this binary tree in Anti-Clockwise direction starting from the root node. 
*/
import java.util.*;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> left=leftBoundary(root);
        ArrayList<Integer> bottom=new ArrayList<>();
        bottomBoundary(root,bottom);
        ArrayList<Integer> right=rightBoundary(root);
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        for(int i:left)ans.add(i);
        for(int i:bottom)ans.add(i);
        for(int i=right.size()-1;i>=0;i--) ans.add(right.get(i));
       return ans;
	}
    public static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    public static ArrayList<Integer> leftBoundary(TreeNode root){
        ArrayList<Integer> tmp=new ArrayList<>();
        root=root.left;
        while(root!=null){
            if(!isLeaf(root)) tmp.add(root.data);
            if(root.left!=null) root=root.left;
            else root=root.right;
        }
        return tmp;
    }
    public static ArrayList<Integer> rightBoundary(TreeNode root){
        ArrayList<Integer> tmp=new ArrayList<>();
        root=root.right;
        while(root!=null){
            if(!isLeaf(root)) tmp.add(root.data);
            
            if(root.right!=null) root=root.right;
            else root=root.left;
        }
        return tmp;
    }
    public static void bottomBoundary(TreeNode root,ArrayList<Integer> bottom){
            if(isLeaf(root)) bottom.add(root.data);
            if(root.left!=null) bottomBoundary(root.left,bottom);
            if(root.right!=null) bottomBoundary(root.right,bottom);
        
    }
}