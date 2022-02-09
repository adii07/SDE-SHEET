/**Problem Statement
You are given an undirected graph in the form of an adjacency matrix along with an integer M. 
You need to tell if you can color the vertices of the graph using at most M colors such that no two adjacent vertices are of the same color.

For Example:
If the given adjacency matrix is:
[0 1 0]
[1 0 1]
[0 1 0] and M = 3.
The given adjacency matrix tells us that 1 is connected to 2 and 2 is connected to 3. 
So if we color vertex 1 with 2, vertex 2 with 1, and vertex 3 with 2, it is possible to color the given graph with 2 colors: M. 


Sample Input 1:
3
3 3
0 1 0
1 0 1
0 1 0 ->YES

3 1
0 1 0
1 0 1
0 1 0 ->NO

2 1
0 1
1 0 ->NO
*/

/**Solution : Backtracking
->Try to set ervery volor on every node if any condition satisfies return true; */

public class Solution {
	public static String graphColoring(int[][] mat, int m) {
		// Write your code here
        int[] colour=new int[mat.length];
        boolean ans=helper(mat,m,colour,0);
        return ans?"YES":"NO";
	}
    public static boolean helper(int[][] mat,int m,int[] colour,int idx){
        if(idx==mat.length) return true;
        
        for(int i=1;i<=m;i++){
            if(isSafe(mat,i,colour,idx)){
                colour[idx]=i;
                if(helper(mat,m,colour,idx+1)) return true;
                colour[idx]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] mat,int m,int[] colour,int idx){
        for(int i=0;i<mat[idx].length;i++){
            if(mat[idx][i]==1){
                if(colour[i]==m)return false;
            }
        }
        return true;
    }
}
