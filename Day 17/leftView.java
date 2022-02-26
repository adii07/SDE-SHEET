/**Left view of a Binary Tree 
Problem Statement:
    ->You have been given a binary tree of integers. 
    ->You are supposed to find the left view of the binary tree. 
    ->The left view of a binary tree is the set of all nodes that are visible when the binary tree is viewed from the left side.
*/


/**Solution1: BFS
-> Use a queue to traverse the tree
-> Add the first element of each level to the ans list  
*/
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int val=Integer.parseInt(q.peek().data+"");
            list.add(val);
            while(size-->0){
                TreeNode top=q.remove();
                if(top.left!=null) q.add(top.left);
                if(top.right!=null) q.add(top.right);
            }
        }
        return list;
    }
}


/**Solution 2: Use HashMap ans Recursion
->Travel the tree recursively and map the level of each node
->increment level by 1 for the child
->Print the 1st element of each level
*/

/**Solution 3: PreOrder travesal
->Travel the tree in an preorder fashion and keep on incrementing the level
->In the function pass along a variable prev_level which maps the highest level previously encountered
->If the current level is greater than the prev_level print the current node and update the value of the prev_level to the current level
*/

import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        helper(root,1,0,list); 
        return list;
    }
    
    public static int helper(TreeNode<Integer> root,int level,int prev_level,ArrayList<Integer> list){
        if(root==null) return prev_level;
        
        if(level>prev_level){
            list.add(Integer.parseInt(root.data+""));
            prev_level=level;
        }
        prev_level=helper(root.left,level+1,prev_level,list);
        prev_level=helper(root.right,level+1,prev_level,list);
        /*
        prev_level=Math.max(prev_level,helper(root.left,level+1,prev_level,list));
        prev_level=Math.max(prev_level,helper(root.right,level+1,prev_level,list));
        */
        return prev_level;
    }
}
