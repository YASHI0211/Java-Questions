class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 0; 
        for (int num:nums){
            if (num==ans){
                count++;
            }
            else {
                count --;
                if (count <0){
                    ans =num;
                    count ++;
                }
            }
        }
        return ans;
    }
}