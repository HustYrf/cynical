package LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int[] start = new int[1];
        int[] end = new int[1];          //使用数组来达到引用传递的目的，而不是值传递
        if (s.length() <= 1) return s;
        for (int i = 0; i < s.length(); i++) {
            function(s, i, i, start, end);//回文串长度为基数
            function(s, i, i + 1, start, end);//回文串长度为偶数
        }
        return s.substring(start[0], end[0] + 1);

    }

    private void function(String s, int i, int j, int[] start, int[] end) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        i++;
        j--; //回退一下
        if (j - i + 1 > end[0] - start[0] + 1) {
            end[0] = j;
            start[0] = i;
        }
    }
}