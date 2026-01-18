class Solution {
    public int hammingWeight(int xor) {
        
        int c=0;
        while (xor>0){
            xor =xor&(xor-1);
            c++;
        }
        return c;
    }
}