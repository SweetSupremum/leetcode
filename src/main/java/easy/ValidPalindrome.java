package easy;

/**
 * @author SweetSupremum
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("9,8"));
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int beginPointer = 0;
        int lastPointer = chars.length - 1;
        while (lastPointer > beginPointer) {
            if (isNoLetterOrNoDigit(chars[beginPointer])) {
                beginPointer++;
                continue;
            }
            if (isNoLetterOrNoDigit(chars[lastPointer])) {
                lastPointer--;
                continue;
            }

            if (chars[beginPointer] != chars[lastPointer]) {
                return false;
            } else {
                beginPointer++;
                lastPointer--;
            }
        }
        return true;
    }

    public boolean isNoLetterOrNoDigit(char c) {
        return (c - 'a' < 0 || c - 'a' >= 26) && (c - 'а' < 0 || c - 'а' >= 32) && (c - '0' < 0 || c - '0' > 9);
    }

}
