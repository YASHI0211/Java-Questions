class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) q.add(i);
        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            res[i++] = curr;
            for (int next : adj.get(curr)) {
                if (--inDegree[next] == 0) q.add(next);
            }
        }
        return i == numCourses ? res : new int[0];
    }
}