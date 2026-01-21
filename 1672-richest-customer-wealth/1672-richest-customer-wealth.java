class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] a : accounts) {
            int sum = 0;
            for (int v : a) sum += v;
            max = Math.max(max, sum);
        }
        return max;
    }
}
