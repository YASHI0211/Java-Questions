class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, i = 0;
        while (i <= high) {
            if (nums[i] == 0) swap(nums, i++, low++);
            else if (nums[i] == 2) swap(nums, i, high--);
            else i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}