package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@see https://leetcode.com/problems/group-anagrams/}
 *
 * @author SweetSupremum
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnagrams().groupAnagrams(strings);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int p = 31;

        Map<Integer, List<String>> hashAnagramStringsMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            int[] hashSymbol = new int[26];
            for (char t : temp) {
                hashSymbol[t - 'a']++;
            }
            int hash = 0;
            for (int j = 0; j < 26; j++) {
                hash += (int) (Math.pow(p, j) % (1E9 + 7)) * hashSymbol[j];
            }
            List<String> stringsForHash = hashAnagramStringsMap.get(hash);
            if (stringsForHash != null) {
                stringsForHash.add(strs[i]);
            } else {
                List<String> newElements = new ArrayList<>();
                newElements.add(strs[i]);
                hashAnagramStringsMap.put(hash, newElements);
            }
        }
        return hashAnagramStringsMap.values().stream().toList();
    }
}
