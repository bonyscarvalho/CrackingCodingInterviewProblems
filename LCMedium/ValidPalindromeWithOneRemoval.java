package LeetCodeMedium;

//680. Valid Palindrome II
public class ValidPalindromeWithOneRemoval {
    public static void main(String args[]) {
        String valid = "foobof";
        String inValid = "abccab";

        System.out.println(validPalindrome(valid));
        System.out.println(validPalindrome(inValid));
    }

    public static boolean validPalindrome(String s) {
        if(s.length() == 0) return true;

        int leftPtr = 0, rightPtr = s.length() - 1;

        while(leftPtr < rightPtr){
            if(s.charAt(leftPtr) == s.charAt(rightPtr)){
                leftPtr++;
                rightPtr--;
            }else{
                return isValidPalindrome(leftPtr + 1, rightPtr, s) || isValidPalindrome(leftPtr, rightPtr - 1, s);
            }
        }

        return true;
    }

    private static boolean isValidPalindrome(int leftPtr, int rightPtr, String s) {
        while (leftPtr < rightPtr) {
            if (s.charAt(leftPtr) == s.charAt(rightPtr)) {
                leftPtr++;
                rightPtr--;
            } else {
                return false;
            }
        }
        return true;
    }
}
