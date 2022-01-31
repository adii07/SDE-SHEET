/**
Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

Examples: 

Input : arr[] = {10, 2, -2, -20, 10}, 
k = -10
Output : 3
Subarrays: arr[0...3], arr[1...4], arr[3..4]
have sum exactly equal to -10.

Input : 
arr[] = {9, 4, 20, 3, 10, 5},
k = 33
Output : 2
Subarrays : arr[0...2], arr[2...4] have sum
exactly equal to 33. 
*/

/** Solution 1: Use 2 for loops
-> calculate all the subarrays and check if their sum is equal to k,if yes increment ans by 1 */
for (int i = 0; i < n; i++) {
    int sum = 0;
    for (int j = i; j < n; j++) {
        sum += arr[j];
        if (sum == k){
            ans++;
        }
    }
}

/**Solution 2: HashMap 
->Calculate the sum at index i
->if the sum is equal to target increment count by 1;
->if map contains(target-sum at index i) add the count of the target-sum to ans
->if sum is already present in the array increment it's count by 1 else add the sum to map with occurence value =1.
*/
int countSubarray(int[]arr, int target){
    HashMap<Integer,Integer> map=new HashMap<>();
    int sum=0;
    int count=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(sum==k){
            count++;
        }
        else if(map.containsKey(sum-target)){
            count+=map.get(sum-target);
        }   
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
}