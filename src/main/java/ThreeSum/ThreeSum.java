package ThreeSum;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1;
                int end = nums.length - 1;
                int target = 0 - nums[i];
                while (start < end) {
                    if (target == nums[start] + nums[end]) {
                        List<Integer> single = new ArrayList<>();
                        single.add(nums[i]);
                        single.add(nums[start]);
                        single.add(nums[end]);
                        result.add(single);
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (target < nums[start] + nums[end]) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}


/**
 * force solution (Time Limit Exceeded) stupid
 */

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums.length < 3) return result;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> single = new ArrayList<>();
//                        single.add(nums[i]);
//                        single.add(nums[j]);
//                        single.add(nums[k]);
//                        Collections.sort(single);
//                        if (!result.contains(single)) {
//                            result.add(single);
//                        }
//
//                    }
//                }
//            }
//        }
//        return result;
//    }

/**
 * error answer
 */
//public List<List<Integer>> threeSum(int[] nums) {
//    List<List<Integer>> result = new ArrayList<>();
//    if (nums.length < 3) return result;
//    Map<Integer, String> map = new HashMap<>();
//    String str;
//    for (int i = 0; i < nums.length; i++) {
//        for (int j = i + 1; j < nums.length; j++) {
//            str = Integer.valueOf(i).toString() + "-" + Integer.valueOf(j).toString();
//            map.put(0 - nums[i] - nums[j], str);
//        }
//    }
//    Set<Integer> integers = map.keySet();
//    for (Integer integet:integers){
//        System.out.println(map.get(integet));
//    }
//    int[] spliteNum = new int[2];
//    for (int i = 0; i < nums.length; i++) {
//        if (map.containsKey(nums[i])) {
//            spliteNum = spliteStr(map.get(nums[i]));
//            if (i != spliteNum[0] && i != spliteNum[1]) {
//                List<Integer> single = new ArrayList<>();
//                single.add(nums[i]);
//                single.add(nums[spliteNum[0]]);
//                single.add(nums[spliteNum[1]]);
//                Collections.sort(single);
//                if (!result.contains(single)) {
//                    result.add(single);
//                }
//            }
//        }
//    }
//    return result;
//}
//
//    private int[] spliteStr(String str) {
//        int[] result = new int[2];
//        String[] split = str.split("-");
//        result[0] = Integer.valueOf(split[0]);
//        result[1] = Integer.valueOf(split[1]);
//        return result;
//    }