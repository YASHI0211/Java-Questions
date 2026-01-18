class Solution {
    public int[] singleNumber(int[] nums) {
        int[] arr= new int[2];
        int xor= 0;
        for (int num:nums){
            xor^=num;

        }
        int rsb = xor &(-xor);
        int xorA=0;
        int xorB=0;
        for (int num: nums){
            if ((num & rsb) ==  0) xorA^=num;
            else xorB^=num;
        }
        arr[0]=xorA;
        arr[1]= xorB;
        return arr;

    }
}