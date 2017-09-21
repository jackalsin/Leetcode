package _301_350._316_Remove_Duplicate_Letters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/20/2017.
 */
public class Solution {
  public String removeDuplicateLetters(String s) {
    return removeDuplicateLettersHelper(s);
//    return exampleSolution(s);
  }

  private String removeDuplicateLettersHelper(String s) {
    final Map<Character, Integer> lastSeen = new HashMap<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; ++i) { // O(n)
      lastSeen.put(chars[i], i);
    }

    StringBuilder sb = new StringBuilder();
    int start = 0;
    while (!lastSeen.isEmpty()) { // O(26)
      int end = getMin(lastSeen);
      char minChar = 'z' + 1;
      int minPos = start;
      for (int i = start; i <= end; ++i) {
        if (minChar > chars[i] && lastSeen.containsKey(chars[i])) {
          minChar = chars[i];
          minPos = i;
        }
      }
      sb.append(minChar);
      start = minPos + 1;
      lastSeen.remove(minChar);
    }

    return sb.toString();
  }

  private int getMin(Map<Character, Integer> lastSeen) {
    int minPos = Integer.MAX_VALUE;
    for (Map.Entry<Character, Integer> entry : lastSeen.entrySet()) {
      if (entry.getValue() < minPos) {
        minPos = entry.getValue();
      }
    }
    return minPos;
  }

}
