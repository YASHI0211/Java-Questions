class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = binarySearchCeil(letters, target);
        return res;
    }
    static char binarySearchCeil( char [] nums, char target){
        char ans='$';
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid = start+(end- start)/2;
           
            if (nums[mid]<=target){
                start = mid+1;
            }
            else{ end=mid-1;
                ans = nums[mid];
            }
        }
        if (ans =='$') return nums [0];
        return ans;
    }

}