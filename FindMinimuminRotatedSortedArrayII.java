public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0]<nums[1]? nums[0]:nums[1];
        int smallest = nums[0];
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1])
                smallest = nums[i+1];
        }
        return smallest;
    }   
}
