class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long imp=0;
        long arr[] = new long[n];
        for (int edges[]: roads){
            arr[edges[0]]++;
            arr[edges[1]]++;
        }
        Arrays.sort(arr);
        
        for (int i=1; i<n+1; i++){
            imp+=arr[i-1]*i;
        }
        return imp;
    }
}