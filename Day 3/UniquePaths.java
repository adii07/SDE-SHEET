/**Leetcode 62 
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
*/

/**Solution1: Recursion
Approach: The problem states that we can either move rightward or downward direction. So we recursively try out all the possible combinations.

1. At first, we are at the (0,0) index let’s assume this state as (i,j). From here we can move towards the bottom as well as towards the right and we recursively move until we hit the base case.
2. At any point of time when the recursive call goes out of the matrix boundary (example: 
        let’s assume m = 2, n= 2, and the current position of i and j is (2,0) which is out of matrix boundary),
        we’ll return zero because from here there are no possible paths beyond and that is the first base case.
3. Whenever the recursive call reaches the end we’ll return 1 because we have found one possible path to reach the end.
4. In the recursive tree what result we have got from the left transition and the right transition will sum it up and return the answer.
*/
 int countPaths(int i,int j,int n,int m)
{
    if(i==(n-1)&&j==(m-1)) return 1;
    if(i>=n||j>=m) return 0;
    else return countPaths(i+1,j,n,m)+countPaths(i,j+1,n,m);
}
int uniquePaths(int m, int n) {
    return countPaths(0,0,m,n);
}

/**Solution2:Dynamic Programming
1. Initialize a dp array of size m*n.
2. Set the base case,ie, when i==m-1 || j==n-1(i.e., the target cell) set value 1
3. For every other cell take sum of the up cell and the left cell
4. return the value at the 0th cell. 
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 || j==n-1){
                    dp[j]=1;
                }else{
                    dp[j]=dp[j]+dp[j+1];
                }
            }
        }
        return dp[0];
    }
}
/**
->This solution is space optimized,i.e, instead of dp array of size m*n we created a dp array of size only n.
->This is because only the previous row is required at the time of calculation rest of the rows are just a overload
*/

/**Solution 3: Combimation 
Intuition: 
->If we observe examples there is a similarity in paths from start to end. 
    Each time we are taking an exactly m+n-2 number of steps to reach the end.
->From start to reach the end we need a certain number of rightward directions and a certain number of downward directions. 
    So we can figure out we need n-1 no. of rightward direction and m-1 no. of downward direction to reach the endpoint.
->Since we need an m+n-2 number of steps to reach the end among those steps if we choose n-1 rightward direction or m-1 downward direction 
    and calculate the combinations ( ie: m+n-2Cn-1 or m+n-2Cm-1) we’ll get the total number of paths.
 */
 int uniquePaths(int m, int n) {
            int i=0;
        long result=1;
        int sum=m+n-2;
        int p=m>n?n:m;
        for(i=0;i<p-1;i++)
        {
            result=result*(sum-i)/(i+1);
        }
        return (int)result;
}

/**
The approach of this solution is very simple just use a for loop to calculate the m+n-2Cn-1  or m+n-2Cm-1 

Dry Run: We’ll take the input m = 2 and n = 3 
According to our observation, 
we need an m+n-2 number of steps to reach the end. 
So we need 3 steps and in every step, we need an n-1 number of rightward direction and m-1 number of downward direction. 
Among 3 steps if we choose 2 rightward directions then the result will be 3 ( 3C2) or among 3 steps if we choose 1 downward direction then the result will also be 3 ( 3C1).


 */    