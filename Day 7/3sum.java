/**Leetcode 15
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: [] */
/** Solution : Sorting & 2 pointer
->Sort the array
->set 1 pointer and apply 2 sum for the rest of the value
->if sum is less than zero we move the left pointer else the right pointer */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return sol;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i<=nums.length-1 ;i++){
           
                int remaining  = target - nums[i] ;
                int front = i+1;
                int back = nums.length-1;
            
                while(front < back){
                    int twoSum = nums[front] + nums[back];
                    if(twoSum < remaining)front++;
                    else if(twoSum >remaining)back--;
                    else{
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[front]);
                        triplet.add(nums[back]);
                        sol.add(triplet);

                        while(front < back && nums[front] == triplet.get(1))front++;
                        while(front < back && nums[back] == triplet.get(2))back--;  
                    }
                }
            while( i+1<=nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return sol;
        
    }
}