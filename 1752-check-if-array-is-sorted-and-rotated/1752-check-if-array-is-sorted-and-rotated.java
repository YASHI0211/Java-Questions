class Solution {
    public boolean check(int[] nums) {
        int n= nums.length;
        int countDrop = 0;
        for (int i=0 ; i<nums.length-1; i++){
            if (nums[i]>nums[i+1]){
                countDrop++;
            }
        }
        if (nums[n-1]>nums[0]) countDrop++;
        if (countDrop>1) return false;
        return true;
    }
}