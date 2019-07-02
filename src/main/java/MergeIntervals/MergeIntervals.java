package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
public class MergeIntervals {
    public int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        List<int[]> result = new ArrayList<>(); //import
        Arrays.sort(arr, new DoubleCompare());
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d,%d\n",arr[i][0],arr[i][1]);
        }
        int left = 0, right = 0;
        int i = 0;
        int len = arr.length;
        while (i < len) {
            left = arr[i][0];
            right = arr[i][1];
            while (i + 1 < len && right >= arr[i + 1][0]) {
                right = Math.max(right, arr[i + 1][1]);
                i++;
            }
            result.add(new int[]{left, right}); //import
            i++;
        }
        int[][] resultArrs = result.toArray(new int[result.size()][2]);
        return resultArrs;
    }


    private class DoubleCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }


    public static void main(String[] args) {
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]
        int[][] arr = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        MergeIntervals obj = new MergeIntervals();
        obj.merge(arr);
    }
}
