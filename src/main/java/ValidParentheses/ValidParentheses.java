package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        HashMap<String, String> map = new HashMap();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        Stack<String> strStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("(") || s.substring(i, i + 1).equals("{") || s.substring(i, i + 1).equals("[")) {
                strStack.push(s.substring(i, i + 1));
            } else {
                if (strStack.size() == 0) return false;
                if (!map.get(s.substring(i, i + 1)).equals(strStack.pop())) {  //使用equal比较字符串
                    return false;
                }
            }
        }
        if(strStack.size()!=0) return false;  //
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
