package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * {@see https://leetcode.com/problems/longest-substring-without-repeating-characters/description/}
 *
 * @author SweetSupremum
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcde"));
    }

    /*    */

    /**
     * dveсdf, abcabcde,pwwkew, tmmzuxt
     */
    public int lengthOfLongestSubstring(String s) {
        int lastNonRepeatSymbol = 0;
        int longestSubstr = 0;
        Map<Character, Integer> symbolLastIndexRepeatSymbolMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (symbolLastIndexRepeatSymbolMap.containsKey(temp)) {
                Integer indexRepeatSymbol = symbolLastIndexRepeatSymbolMap.get(temp);
                lastNonRepeatSymbol = Math.max(indexRepeatSymbol + 1, lastNonRepeatSymbol);
            }
            symbolLastIndexRepeatSymbolMap.put(temp, i);
            longestSubstr = Math.max(longestSubstr, i - lastNonRepeatSymbol + 1);
        }
        return longestSubstr;
    }

}
