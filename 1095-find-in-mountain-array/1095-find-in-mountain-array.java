/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n= mountainArr.length();
        int s=0;
        int e=n-1;
        int mid =-1;
        while(s<=e){
            mid=s+(e-s)/2;
            int cur = mountainArr.get(mid);
            if (mid!=0 && mid!=n-1 && cur>mountainArr.get(mid-1) && cur>mountainArr.get(mid+1)){
                if(cur== target) return mid;

                
                break;
            }
            else if (mid!=n-1 && cur < mountainArr.get(mid+1)){
                s=mid+1;

            }
            else {e=mid-1;
    }
        }
        int start =0;
        int end =mid-1;
        while(start <=end){
            int m=start +(end-start)/2;
            int cur = mountainArr.get(m);
            if (cur == target){
                return m;
            }
            else if (target<cur){
                end=m-1;

            }
            else {
                start=m+1;
            }
        }
        start =mid+1;
        end = n-1;
        while(start<=end ){
            int m = start +(end-start)/2;
            int cur= mountainArr.get(m);
            if (cur==target){
                return m;

            }
            else if (target<cur) start =m+1;
            else end =m-1;
        }
        return -1;
    }
}