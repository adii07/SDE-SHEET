/**leetcode 128
Longest Consecutive Sequence in an Array
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Input: [100, 200, 1, 3, 2, 4]
Output: 4
Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.

Input: [3, 8, 5, 7, 6]
Output: 4
Explanation: The longest consecutive subsequence is 5, 6, 7, and 8. 
*/

/**Solution 1: Sort the array look for the longest consecutive sequence */
public static int longestConsecutive(int[] nums) {
    if(nums.length == 0 || nums == null){
        return 0;
    }
        
    Arrays.sort(nums);
        
    int ans = 1;
    int prev = nums[0];
    int cur = 1;
        
    for(int i = 1;i < nums.length;i++){
        if(nums[i] == prev+1){
            cur++;
        }
        else if(nums[i] != prev){
            cur = 1;
        }
        prev = nums[i];
        ans = Math.max(ans, cur);
    }
    return ans;
}

/**Solution 2: HashMap 
->Add all the elements in a hashmap
->for a element x check if x-1 is present in the hashmap if yes skip x and move forward
->if x-1 is absent check for the sequence starting from the xth element. 
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) { // not contains x-1 
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
