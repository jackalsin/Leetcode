package _0401_0450._438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public final class SecondTry implements Solution {
  @Override
  public List<Integer> findAnagrams(String s, String p) {
    final List<Integer> result = new ArrayList<>();
    int uniqueCount = 0;
    final int[] counts = new int[26];
    for (char chr : p.toCharArray()) {
      if (counts[chr - 'a'] == 0) {
        uniqueCount++;
      }
      counts[chr - 'a']++;
    }

    for (int start = 0, end = 0; end < s.length(); ) {
      if (--counts[s.charAt(end++) - 'a'] == 0) {
        uniqueCount--;
      }

      while (uniqueCount == 0) {
        final char startChar = s.charAt(start);
        if (++counts[startChar - 'a'] > 0) {
          uniqueCount++;
        }
        if (end - start == p.length()) {
          result.add(start);
        }
        start++;
      }
    }
    return result;
  }
}
