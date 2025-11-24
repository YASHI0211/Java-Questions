class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List <Boolean> ans = new ArrayList<>();
        int curr=0;
        for(int num : nums){
            int newNum = (curr<<1 | num);
            if (newNum%5 ==0){
                ans.add(true);
            }
            else ans.add (false);
            curr=newNum%5;

        }
        return ans;
    }
}