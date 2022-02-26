/**Top view of a Binary Tree*/

/**Solution 1: Use a HashMap 
->Store the First node at each width 
->Left child has a width -1 to the parent node
->Right child has a width +1 to the parent node
*/
import java.util.*;
class Pair{
    BinaryTreeNode node;
    int width;
    Pair(BinaryTreeNode node,int width){
        this.node=node;
        this.width=width;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int min=Integer.MAX_VALUE;int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair top=q.remove();
            min=Math.min(min,top.width);
            max=Math.max(max,top.width);
            if(!map.containsKey(top.width)){
            	map.put(top.width,top.node.val);
            }
            if(top.node.left!=null) q.add(new Pair(top.node.left,top.width-1));
            if(top.node.right!=null) q.add(new Pair(top.node.right,top.width+1));
        }
        while(min<=max){
            ans.add(map.get(min++));
        }
        return ans;
	}
}