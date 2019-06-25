package LetterCombinationsOfAPhoneNumber;

import AddTwoNumbers.AddTwoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    static String[] num2digit = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() <= 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            func(digits.substring(i, i + 1), result);
        }
        return result;

    }

    private static void func(String str, List<String> result) {
        String str2digit = num2digit[str.charAt(0) - '0'];
        List<String> strings = copyList(result);
        for (int i = 0; i < str2digit.length(); i++) {
            for (String s : strings) {
                result.remove(s);
                result.add(s + str2digit.substring(i, i + 1));
            }
        }
    }

    private static List<String> copyList(List<String> result) {
        List<String> copyList = new ArrayList<>();
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            copyList.add(iterator.next());
        }
        return copyList;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23456");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
