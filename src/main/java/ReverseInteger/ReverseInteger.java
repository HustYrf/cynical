package ReverseInteger;

public class ReverseInteger {
    public static int reverse(int x) {
        long n = 0;     //此处定义为long类型
        int[] result = new int[32];
        int count = 0;
        while (x != 0) {
            result[count++] = x % 10;
            x = x / 10;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) continue;
            start = i;
            break;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0) continue;
            end = i;
            break;
        }
        for (int i = start; i <= end; i++) {
            n = n * 10 + result[i];
        }
        if (n < Integer.MAX_VALUE && n > Integer.MIN_VALUE) {
            return (int)n;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
}
