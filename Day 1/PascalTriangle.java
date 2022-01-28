/** leetcode 118.
In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:


Example 1:
Input Format: N = 5
Result:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
 */

 class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) temp.add(1);
                else{
                    int a=ans.get(i-1).get(j-1);
                    int b=ans.get(i-1).get(j);
                    temp.add(a+b);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}