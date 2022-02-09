/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        getList(nums,list,new ArrayList<>());
        return list;
    }
    
    public void getList(int[] a, List<List<Integer>> list,ArrayList<Integer> subList){
        if(subList.size()==a.length){
            list.add(new ArrayList<>(subList));
        }
        else{
            for(int i=0;i<a.length;i++){
                if(subList.contains(a[i])) continue;
                subList.add(a[i]);
                getList(a,list,subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}