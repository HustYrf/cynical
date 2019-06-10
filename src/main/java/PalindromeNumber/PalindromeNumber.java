package PalindromeNumber;


public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int sinNum = x; //保存原始值
        if (x < 0) return false;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result == sinNum){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
