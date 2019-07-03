## LeetCode   递归回溯法总结

##### 78.Subsets

```java
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        dfs(result, 0, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, int start, List<Integer> cur, int[] nums) {
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(Integer.valueOf(nums[i]));
            dfs(result, i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
```

##### 90.Subsets II
```java
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtracing(result, list, nums, 0);
        return result;
    }

    private void backtracing(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;  //注意此处
            list.add(nums[i]);
            backtracing(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
```
##### 46.Permutations 
```java
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
}
```
##### 47.Permutations II
```java
package Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTracing(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backTracing(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backTracing(result, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
```

##### 39.Combination Sum
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        recursiveAndBacktrace(candidates, result, list, target, target, 0);
        return result;
    }

    private void recursiveAndBacktrace(int[] nums, List<List<Integer>> result, List<Integer> list, int target, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
             result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);//list装一下数据
                recursiveAndBacktrace(nums, result, list, target, remain - nums[i], i);
                list.remove(list.size() - 1);//回退一个数据
            }
        }
    }
}
```

##### 40.Combination Sum II
```java
package CombinationSum2;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTracing(result, new ArrayList<>(), target, 0, candidates);
        return result;
    }

    private void backTracing(List<List<Integer>> result, List<Integer> list, int remain, int start, int[] candidates) {
        if (remain < 0) return;
        if (remain == 0) result.add(new ArrayList<>(list));
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backTracing(result, list, remain - candidates[i], i + 1, candidates);
            list.remove(list.size() - 1);
        }
    }

}
```

##### 131.Palindrome Partitioning
```java
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
```

