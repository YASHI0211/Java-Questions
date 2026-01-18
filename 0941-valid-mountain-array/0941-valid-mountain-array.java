class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length<3) return false;
        int in=0;
        for (int i=1; i<arr.length; i++) {
                if (arr[i]>arr[i-1]) in++;                 
        }
        ;
        if (in==0|| in==arr.length-1) return false;
        for (int ind=in; ind<=arr.length-2; ind++){
            if(arr[ind]<=arr[ind+1]) return false;
        }    
        return true;
}
}