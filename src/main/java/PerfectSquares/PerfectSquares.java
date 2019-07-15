package PerfectSquares;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

//dp[n] = Min{ dp[n - i*i] + 1 },i=(int) Math.sqrt(n);
public class PerfectSquares {
    public int numSquares(int n) {
        if (n < 1) return n;
        int sqrtNum, min;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            sqrtNum = (int) Math.sqrt(i);
            min = n + 1;
            for (int j = 1; j <= sqrtNum; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(13));
    }
}


//public class PerfectSquares {
//    public int numSquares(int n) {
//        if (n <= 1) return n;
//        int sqrtNum = (int) Math.sqrt(n);
//        int[] arrs = new int[sqrtNum];
//        generate(arrs, sqrtNum);
//        int temp, size, j;
//        int result = n + 1;
//        for (int i = 0; i < arrs.length; i++) {
//            temp = 0;
//            size = 0;
//            j = i;
//            while (j < arrs.length) {
//                temp += arrs[j];
//                size++;
//                if (temp == n) {
//                    result = Math.min(result, size);
//
//                    break;
//                } else if (temp < n) {
//                    continue;
//                } else {
//                    temp -= arrs[j];
//                    j++;
//                    size--;
//                }
//            }
//
//        }
//        return result;
//    }
//
//    private void generate(int[] arrs, int sqrtNum) {
//        int index = 0;
//        for (int i = sqrtNum; i >= 1; i--) {
//            arrs[index++] = i * i;
//        }
//    }
//
//    public static void main(String[] args) {
//        PerfectSquares p = new PerfectSquares();
//        System.out.println(p.numSquares(43));
//    }
//}
