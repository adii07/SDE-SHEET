/**
Subset – II | Print all the Unique Subsets
Problem Statement: Given an array of integers that may contain duplicates the task is to return all possible subsets. Return only unique subsets and they can be in any order.

Examples:

Example 1:

Input: array[] = [1,2,2]

Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]

Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.

Input: array[] = [1]

Output: [ [ ], [1] ]

Explanation: Only two unique subsets are available
 */


 /**
 Let’s summarize:-

Sort the input array.Make a recursive function that takes the input array ,the current subset,the current index and  a list of list/ vector of vectors to contain the answer.
Try to make a subset of size n during the nth recursion call and consider elements from every index while generating the combinations. Only pick up elements that are appearing for the first time during a recursion call to avoid duplicates.
Once an element is picked up, move to the next index.The recursion will terminate when the end of array is reached.While returning backtrack by removing the last element that was inserted. */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        helper(nums,0,ans,subans);
        return ans;
    }
    public void helper(int[] nums,int idx,List<List<Integer>> ans, List<Integer> subans) {
        if (idx <= nums.length) {
            ans.add(new ArrayList<>(subans));
        }
        int i = idx;
        while (i < nums.length) {
            subans.add(nums[i]);
            helper(nums,i+1,ans,subans);
            subans.remove(subans.size() - 1);
            i++;
            while (i<nums.length && nums[i]==nums[i-1]) {i++;}
        }
    }
}
                                                /**OR */
public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds)); 
        for(int i = ind;i<nums.length;i++) {
            if(i!=ind && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ansList); 
            ds.remove(ds.size() - 1);
        }
        
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> ansList = new ArrayList<>(); 
        findSubsets(0, nums, new ArrayList<>(), ansList); 
        return ansList; 
    }