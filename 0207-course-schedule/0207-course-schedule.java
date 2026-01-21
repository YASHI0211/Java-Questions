class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) q.add(i);
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next : adj.get(curr)) {
                if (--inDegree[next] == 0) q.add(next);
            }
        }
        return count == numCourses;
    }
}