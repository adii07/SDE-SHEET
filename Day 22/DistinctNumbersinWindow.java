/**Distinct Numbers in Window
Problem Description

You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE:  if B > N, return an empty array.

Input Format
First argument is an integer array A
Second argument is an integer B.

Output Format
Return an integer array.

Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1
Example Output
Output 1:
[2, 3, 3, 2]
Output 2:
[1, 1, 1, 1]
*/
/**HashMap */
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> set=new HashMap<>();
        for(int i=0;i<B;i++){
            int n=set.getOrDefault(A.get(i),0);
            set.put(A.get(i),n+1);
        }
        list.add(set.size());
        for(int i=1;i<=A.size()-B;i++){
            int n=set.get(A.get(i-1));
            if(n<=1){
                set.remove(A.get(i-1));
            }else{
                set.put(A.get(i-1),n-1);
            }
            n=set.getOrDefault(A.get(i+B-1),0);
            set.put(A.get(i+B-1),n+1);
            list.add(set.size());
        }
        return list;
    }
}
