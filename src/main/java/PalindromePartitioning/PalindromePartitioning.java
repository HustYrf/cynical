package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracing(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backTracing(List<List<String>> result, List<String> list, String s, int start) {
        if (start == s.length())
            result.add(new ArrayList<>(list));
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                backTracing(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
