class Solution {
    public int[] constructRectangle(int area) {
        int wid = (int) Math.sqrt(area);
        while(area%wid != 0){
            wid--;
        }
        int hig = area/wid;
        int arr[]= new int [2];
        arr[0]=hig;
        arr[1]=wid;
        return arr;
    }
}