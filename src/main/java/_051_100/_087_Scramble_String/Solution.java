package _051_100._087_Scramble_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/27/2017.
 */
public class Solution {
  public boolean isScramble(String s1, String s2) {
//    return recursiveSolution(s1, s2);
    return dpSolution(s1, s2);

  }

  private boolean dpSolution(String s1, String s2) {
    final Map<String, Boolean> wordPairToCount = new HashMap<>();
    boolean result = wordPairToCount(wordPairToCount, s1, s2);
    System.out.println(wordPairToCount);
    return result;
  }

  private boolean wordPairToCount(final Map<String, Boolean> wordPairToCount,
                                  String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.equals(s2)) {
      return true;
    } else if (s1.length() != s2.length()) {
      return false;
    } else if (wordPairToCount.containsKey(s1 + s2)) {
      return wordPairToCount.get(s1 + s2);
    } else {
      for (int i = 1; i < s1.length(); i++) {
        if ((wordPairToCount(wordPairToCount,s1.substring(0, i), s2.substring(0, i)) &&
                 wordPairToCount(wordPairToCount,s1.substring(i), s2.substring(i)))
                || (wordPairToCount(wordPairToCount,s1.substring(0, i), s2.substring(s2.length() - i))
                        && wordPairToCount(wordPairToCount, s1.substring(i), s2.substring(0, s2.length() - i))
        )) {
          wordPairToCount.put(s1 + s2, true);
          return true;
        }
      }
      wordPairToCount.put(s1 + s2, false);
      return false;
    }
  }

  /**
   * Exponential Complexity: (N - 1) ways to divide. All the non-leaf nodes can be swapped, which
   * adds up to (2^1 + 2^2+ 2^3 + ... + 2^N)
   * @param s1
   * @param s2
   * @return
   */
  private static boolean recursiveSolution(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.equals(s2)) {
      return true;
    } else if (s1.length() != s2.length()) {
      return false;
    } else {
      for (int i = 1; i < s1.length(); i++) {
        if ((recursiveSolution(s1.substring(0, i), s2.substring(0, i)) && recursiveSolution(s1.substring(i), s2.substring(i)))
                || (recursiveSolution(s1.substring(0, i), s2.substring(s2.length() - i))
                        && recursiveSolution(s1.substring(i), s2.substring(0, s2.length() - i))
        )) {
          return true;
        }
      }
      return false;
    }
  }
}
