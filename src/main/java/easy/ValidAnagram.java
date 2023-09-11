package easy;

/**
 * {@see https://leetcode.com/problems/valid-anagram/}
 *
 * @author SweetSupremum
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounterMap = new int[26];
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            charCounterMap[tChars[i] - 'a']++;
            charCounterMap[sChars[i] - 'a']--;
        }

        for (var count : charCounterMap) {
            if (count != 0) return false;
        }
        return true;
    }


}
