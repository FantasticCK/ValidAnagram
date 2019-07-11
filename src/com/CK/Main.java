package com.CK;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s = "hello";
        String t = "ollhk";

        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s, t));

    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t) || (s.isEmpty() && t.isEmpty())) return true;
        Map<Character, Integer> sCharMap = charMapOfString(s), tCharMap = charMapOfString(t);
        Set<Character> keySet = sCharMap.keySet();
        for (Character key : keySet) {
            if (!sCharMap.get(key).equals(tCharMap.get(key))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> charMapOfString(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        if (s.isEmpty()) return charMap;
        for (Character c : s.toCharArray()) {
            Integer value = charMap.containsKey(c) ? charMap.get(c) + 1 : 1;
            charMap.put(c, value);
        }
        return charMap;
    }

}

// Array Sorting
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

// Hash Table

class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}