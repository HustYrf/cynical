package LongestCommonPrefix;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String result = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        for (int i = 0; i < min; i++) {
            String s = strs[0].substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!s.equals(strs[j].substring(i, i + 1))) {
                    return result;
                }
            }

            result += s;
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "flight";
        System.out.println(longestCommonPrefix(strs));
    }

}
