class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, target, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(res, temp, nums, remain - nums[i], i); // not i + 1 because we can reuse elements
                temp.remove(temp.size() - 1);
            }
        }
    }
}