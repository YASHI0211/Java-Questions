class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            int resi = -1;
            int j = nums2.length -1;
            while(nums1[i] != nums2[j]){
                if(nums1[i] < nums2[j])
                resi = nums2[j];
                j--;
            }
            result[i] = resi;
        }
        return result;
    }
}