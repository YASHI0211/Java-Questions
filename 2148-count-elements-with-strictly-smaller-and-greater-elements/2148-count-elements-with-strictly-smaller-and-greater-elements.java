class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length ;
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int num : nums){
            h1.put(num, h1.getOrDefault(num,0) + 1);
        }

       int x = h1.get(nums[0]);
       int y = h1.get(nums[n-1]);

        if(nums[0] == nums[n-1]){
            return 0 ;
        }
        if( n > 2){
            return n-x-y ;
        }
        return 0 ;
    }
}