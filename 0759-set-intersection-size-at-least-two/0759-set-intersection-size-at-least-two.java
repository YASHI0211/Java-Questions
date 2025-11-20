class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int picks = 0;
        int secondLast = -1;
        int last = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            int insideCount = 0;
            if (secondLast >= start) insideCount++;
            if (last >= start) insideCount++;

            if (insideCount == 2) continue;

            if (insideCount == 1) {
                picks++;
                secondLast = last;
                last = end;
            } else {
                picks += 2;
                secondLast = end - 1;
                last = end;
            }
        }

        return picks;
    }
}
