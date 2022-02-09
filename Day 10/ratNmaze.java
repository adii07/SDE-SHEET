/**Rat In a Maze All Paths
*You are given a 'N' * 'N' maze with a rat placed at 'MAZE[0][0]'. Find and print all paths that rat can follow to reach its destination i.e. 'MAZE['N' - 1]['N' - 1]'. 
*Rat can move in any direc­tion ( left, right, up and down).
*Value of every cell in the 'MAZE' can either be 0 or 1. Cells with value 0 are blocked means the rat can­not enter into those cells and those with value 1 are open.

Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Explanation For Sample Output 1:
Only 1 path is possible which contains coordinate < (1,1), (2,1), (3,1), (3,2) and (3,3) >
So our path matrix will look like this:
1 0 0
1 0 0
1 1 1
Which is returned from left to right and then top to bottom in one line.

Sample Input 2 :
2
1 0
0 1
Sample Output 2 :
 [Blank]
Explanation For Sample Output 2:
As no path is possible to the last cell, a blank vector will be returned and nothing is printed.*/

/**Solution 1: Backtracking */
import java.util.*;
public class Solution {
   public static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        ans=new ArrayList<>();
        helper(maze,n,0,0);
        return ans;
    }
    
    public static void helper(int[][] maze,int n,int row,int col){
        if(row<0 || col<0 || row>=n || col>=n || maze[row][col]==0 ||maze[row][col]==-1) return;
        if(row==n-1 && col==n-1){
            if(maze[row][col]==0) return;
            maze[row][col]=-1;
            addToList(maze);
            maze[row][col]=1;
            return;
        }
        maze[row][col]=-1;
        helper(maze,n,row-1,col);
        helper(maze,n,row+1,col);
        helper(maze,n,row,col-1);
        helper(maze,n,row,col+1);
        maze[row][col]=1;
    }
    public static void addToList(int[][] maze){
        List<Integer> subans=new ArrayList<>();
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                if(maze[i][j]==-1) subans.add(1);
                else subans.add(0);
            }
        }
        ans.add(new ArrayList(subans));
    }
}