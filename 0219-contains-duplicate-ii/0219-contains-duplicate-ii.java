class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> m = new HashMap<>();//created an empty HashMap

        for(int i = 0; i<nums.length; i++){ //loop to check every Number from nums
            if(m.containsKey(nums[i])){
                int prevIndex = m.get(nums[i]);

                if(i - prevIndex <=k){
                    return true;
                }
            }

            m.put(nums[i],i);//store or update the latest index at this number.
        }
        return false;
        
    }
}