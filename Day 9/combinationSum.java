/**Combination Sum – 1
Problem Statement: 

Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: array = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.7 is a candidate, and 7 = 7.These are the only two combinations.

Example 2:
Input: array = [2], target = 1
Output: []
Explaination: No combination is possible. */

/**Solution 1:“pick and non-pick” 
->If you pick the element, again come back at the same index as multiple occurrences of the same element is possible so the target reduces to target – arr[index] (where target -arr[index]>=0)and also insert the current element into the data structure.
->If you decide not to pick the current element, move on to the next index and the target value stays as it is. Also, the current element is not inserted into the data structure.
->While backtracking makes sure to pop the last element as shown in the recursion tree below.
->Keep on repeating this process while index < size of the array for a particular recursion call. */
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0,new ArrayList<>());
        return ans;
    }
    public void helper(int[] candidates,int target,int idx,List<Integer> subans){
        if(target<0) return;
        if(target ==0){
            ans.add(new ArrayList<>(subans));
            return;
        }
        if(idx>=candidates.length)return;
        if(candidates[idx]<=target){
                subans.add(candidates[idx]);
                helper(candidates,target-candidates[idx],idx,subans);
                subans.remove(subans.get(subans.size()-1));
            }
            helper(candidates,target,idx+1,subans);
        
    }
}