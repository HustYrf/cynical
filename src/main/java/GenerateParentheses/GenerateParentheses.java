package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    String leftBrackets = "(";
    String rightBrackets = ")";

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursiveSolution(result, "", 0, 0, n);
        return result;
    }

    private void recursiveSolution(List<String> result, String single, int left, int right, int max) {
        if (single.length() == max * 2) {
            result.add(single);
            return;
        }
        if (left < max) {
            recursiveSolution(result, single + leftBrackets, left + 1, right, max);
        }
        if (right < left) {
            recursiveSolution(result, single + rightBrackets, left, right + 1, max);
        }
    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
