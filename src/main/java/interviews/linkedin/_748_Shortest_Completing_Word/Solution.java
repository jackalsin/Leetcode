package interviews.linkedin._748_Shortest_Completing_Word;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    final Map<Character, Integer> map = new HashMap<>();
    for (char chr : licensePlate.toCharArray()) {
      final char normedChar = Character.toLowerCase(chr);
      if (Character.isAlphabetic(normedChar)) {
        map.put(normedChar, map.getOrDefault(normedChar, 0) + 1);
      }
    }

    System.out.println(map);

    int minLen = Integer.MAX_VALUE;
    String minMatch = "";
    for (String word : words) {
      if (minLen > word.length() && matches(word, map)) {
        minLen = word.length();
        minMatch = word;
      }
    }
    assert minLen != Integer.MAX_VALUE;
    return minMatch;
  }

  private static boolean matches(String word, final Map<Character, Integer> srcMap) {
    final Map<Character, Integer> map = new HashMap<>(srcMap);
    int count = srcMap.size();
    for (char chr : word.toCharArray()) {
      if (map.containsKey(chr)) {
        map.put(chr, map.get(chr) - 1);
        if (map.get(chr) == 0) {
          count--;
        }
      }
    }
    return count == 0;
  }
}
