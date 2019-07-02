package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

//    public class DoubleCompare implements Comparator<Integer> {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            if (o1 == o2) return 0;
//            else {
//                return o1 < 02 ? 1 : -1;
//            }
//        }
//    }
}