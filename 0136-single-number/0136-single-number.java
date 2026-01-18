class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int singleNumber=nums[0];
        for (int i=1; i<n; i++){
            singleNumber^=nums[i];
        }
        return singleNumber;
    }
}