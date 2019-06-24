package LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int maxLen = 0, index;
        String subStr;
        for (int i = 0; i < s.length(); i++) {
            subStr = s.substring(i, i + 1);
            index = sb.indexOf(subStr);
            if (index == -1) {
                sb.append(subStr);
                if (sb.length() > maxLen) {
                    maxLen = sb.length();
                }
                continue;
            } else {
                if (sb.length() > maxLen) {
                    maxLen = sb.length();
                }
                if (index == sb.length() - 1) {
                    sb = new StringBuilder(subStr);
                } else {
                    sb = new StringBuilder(sb.substring(index + 1) + subStr);
                }
            }
        }
        return maxLen;
    }

    /**optimized answer1*/
//    public class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            int n = s.length(), ans = 0;
//            Map<Character, Integer> map = new HashMap<>(); // current index of character
//            // try to extend the range [i, j]
//            for (int j = 0, i = 0; j < n; j++) {
//                if (map.containsKey(s.charAt(j))) {
//                    i = Math.max(map.get(s.charAt(j)), i);
//                }
//                ans = Math.max(ans, j - i + 1);
//                map.put(s.charAt(j), j + 1);
//            }
//            return ans;
//        }
//    }


    /**optimized answer2*/
//    public class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            int n = s.length(), ans = 0;
//            int[] index = new int[128]; // current index of character
//            // try to extend the range [i, j]
//            for (int j = 0, i = 0; j < n; j++) {
//                i = Math.max(index[s.charAt(j)], i);
//                ans = Math.max(ans, j - i + 1);
//                index[s.charAt(j)] = j + 1;
//            }
//            return ans;
//        }
//    }

}
