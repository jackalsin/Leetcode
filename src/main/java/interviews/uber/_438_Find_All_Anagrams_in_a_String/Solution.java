package interviews.uber._438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char chr : p.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }
    final List<Integer> result = new ArrayList<>();

    int count = charCounts.size();
    for (int start = 0, end = 0; end < s.length(); ) {
      final char newChar = s.charAt(end);
      if (charCounts.containsKey(newChar)) {
        charCounts.put(newChar, charCounts.get(newChar) - 1);
        if (charCounts.get(newChar) == 0) count--;
      }
      end++;

      while (count == 0) {
        final char removedChar = s.charAt(start);
        if (charCounts.containsKey(removedChar)) {
          charCounts.put(removedChar, charCounts.get(removedChar) + 1);
          if (charCounts.get(removedChar) > 0) { // TODO: check
            count++;
          }
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
