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
