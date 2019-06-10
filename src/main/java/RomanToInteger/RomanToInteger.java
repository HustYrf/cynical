package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> m = new HashMap();
        int result = 0;
        s = s + "Y";
        m.put("I", 1);
        m.put("V", 5);
        m.put("X", 10);
        m.put("L", 50);
        m.put("C", 100);
        m.put("D", 500);
        m.put("M", 1000);
        m.put("Y", 1610);  //结束位
        if (s.length() == 1) return result;
        for (int i = 0; i < s.length() - 1; i++) {
            if (m.get(s.substring(i+1, i + 2)) == 1610){
                result += m.get(s.substring(i, i + 1));
                break;
            }
            if (m.get(s.substring(i, i + 1)) >= m.get(s.substring(i + 1, i + 2))) {
                result += m.get(s.substring(i, i + 1));
            } else {
                result += (m.get(s.substring(i + 1, i + 2)) - m.get(s.substring(i, i + 1)));
                i++;
            }
        }
        return result;
    }
}
