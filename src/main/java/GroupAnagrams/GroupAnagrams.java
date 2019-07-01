package GroupAnagrams;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        Map<String, List<String>> originMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (originMap.containsKey(sortStr)) {
                originMap.get(sortStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                originMap.put(sortStr, list);
            }
        }
        Set<String> strings = originMap.keySet();
        for (String s : strings) {
            result.add(originMap.get(s));
        }
        return result;
    }


    /**
     * stupid answer (TLE)
     */
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        if (strs.length == 0) return result;
//        List<String> originList = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            originList.add(strs[i]);
//        }
//        String fistStr;
//        while (originList.size() != 0) {
//            fistStr = originList.get(0);
//            List<String> strings = new ArrayList<>();
//            for (int i = 0; i < strs.length; i++) {
//                if (isSimilar(fistStr, strs[i])) {
//                    originList.remove(strs[i]);
//                    strings.add(strs[i]);
//                }
//            }
//            result.add(strings);
//        }
//        return result;
//    }
//
//    private static boolean isSimilar(String src, String target) {
//        if (src.length() != target.length()) return false;
//        char[] srcArray = src.toCharArray();
//        char[] targetArray = target.toCharArray();
//        Arrays.sort(srcArray);
//        Arrays.sort(targetArray);
//        if(Arrays.equals(srcArray,targetArray))
//            return true;
//        return false;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(isSimilar("abc", "cba"));
//    }
}
