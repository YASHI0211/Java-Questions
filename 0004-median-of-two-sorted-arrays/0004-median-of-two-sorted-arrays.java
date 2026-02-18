class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

       int i=0;
       int j=0 ;
       int index =0 ;
      double[] arr = new double[n+m];
       while(i<n && j <m){
        if(nums1[i] < nums2[j]){
            arr[index++] = nums1[i];
            i++;
            
        }
        else{
            arr[index++] = nums2[j];
            j++;
        }
       }

       while(i < n){
    arr[index++] = nums1[i++];
}

while(j < m){
    arr[index++] = nums2[j++];
}

       for(int k=0 ; k<n+m ;k++){
        System.out.print(arr[k]);
       }
    //    return index;
    int s = arr.length;
    int right = s-1;
    int left = 0;
    for(int k=0;k<arr.length ;k++){
        int mid = (right - left +1)/2 ;
        if(s%2 != 0){  // odd
            return arr[mid] ;
        }else{
            int midplus1 = mid -1 ;
            return (arr[mid]+arr[midplus1])/2;
        }
    }
    return 0 ;
    }
}