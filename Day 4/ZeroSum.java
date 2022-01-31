/**Length of the longest subarray with zero Sum
Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

Example 1:

Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!

Example 2:
Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
Result: 8
Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
Length of longest subarray = 8

Example 3:
Input Format: N = 3, array[] = {1, 0, -5}
Result: 1
Subarray : {0}
Length of longest subarray = 1

Example 4:
Input Format: N = 5, array[] = {1, 3, -5, 6, -2}
Result: 0
Subarray: There is no subarray that sums to zero
 */

 /**Solution 1: Use 2 for loops 
 -> check all the subarrays*/
 static int solve(int[] a){
	int  max = 0;
	for(int i = 0; i < a.length; ++i){
		int sum = 0;
		for(int j = i; j < a.length; ++j){
			sum += a[j];
			if(sum == 0){
				max = Math.max(max, j-i+1);
			}
		}
	}
	return max;
   }


/**Solution 2: HashMap 
->calculate the sum at each index
->if the sum is zero subarray length=index+1
->else if map contains the sum , it means that the subarray between these 2 points was zero.
    therefore the length of subarray is map.get(sum)-index
-> else put the sum value in map along with index in which it occoured
Note: we donot update the sum value if it repeats as we want the max subarray length
*/
public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
    int ans=0;
    int sum=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<arr.size();i++){
        sum+=arr.get(i);
            
        if(sum==0){
            ans=i+1;
        }else if(map.containsKey(sum)){
            ans=Math.max(ans,(i-map.get(sum)));
        }else{
            map.put(sum,i);
        }
    }
    return ans;
}