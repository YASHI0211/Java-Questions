class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;  // cost to reach step i-2
        int cur = 0;   // cost to reach step i-1

        for (int i = 0; i < cost.length; i++) {
            int next = Math.min(prev, cur) + cost[i];
            prev = cur;
            cur = next;
        }

        return Math.min(prev, cur);
    }
}
