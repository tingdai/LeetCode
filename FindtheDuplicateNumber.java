public class Solution {
    public int findDuplicate(int[] nums) {
        int dup = 0;
        for (int i = 0; i<nums.length; i++)
        {
            for (int j = 0; j<nums.length; j++)
            {
                if (nums[i] > nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else if(nums[i] == nums[j] && i != j){
                    dup = nums[i];
                    return dup;
                }
            }
        }
        return dup;
    }
}
