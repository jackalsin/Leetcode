package _251_300._290_Word_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/6/2017.
 */
public class Solution {
  public boolean wordPattern(String pattern, String str) {
//    return twoHashSetsSolution(pattern, str);
    return saveLastIndex(pattern, str);
  }

  /**
   * The lesson is that problems related to pattern can use lastSeenPosition
   *
   * @param pattern
   * @param str
   * @return
   */
  private boolean saveLastIndex(String pattern, String str) {
    Map<Character, Integer> lastSeenInPattern = new HashMap<>();
    Map<String, Integer> lastSeenInStr = new HashMap<>();
    String[] words = str.split(" ");
    if (words.length != pattern.length()) return false;
    for(int i = 0; i < pattern.length(); ++i) {
      if (!Objects.equals(
          lastSeenInPattern.put(pattern.charAt(i), i),(lastSeenInStr.put(words[i], i))
      )) {
        return false;
      }
    }
    return true;
  }

  private static boolean twoHashSetsSolution(String pattern, String str) {
    Map<Character, List<Integer>> charsIndex = new HashMap<>();
    char[] chars = pattern.toCharArray();
    for(int i = 0; i < chars.length; ++i) {
      charsIndex.putIfAbsent(chars[i], new ArrayList<>());
      charsIndex.get(chars[i]).add(i);
    }
    Map<String, List<Integer>> wordsIndex = new HashMap<>();
    String[] words = str.split(" ");
    if (words.length != pattern.length()) return false;
    for (int i = 0; i < words.length; ++i) {
      wordsIndex.putIfAbsent(words[i], new ArrayList<>());
      wordsIndex.get(words[i]).add(i);
    }
//    System.out.println(charsIndex.values());
//    System.out.println(wordsIndex.values());
    return new HashSet<>(charsIndex.values()).equals(new HashSet<>(wordsIndex.values()));
  }
}
