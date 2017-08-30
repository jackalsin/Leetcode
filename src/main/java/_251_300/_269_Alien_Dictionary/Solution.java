package _251_300._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/29/2017.
 */
public class Solution {
  public String alienOrder(String[] words) {
    Map<Character, Integer> prevCharacterCounts = new HashMap<>();
    Map<Character, Set<Character>> smallToChildren = new HashMap<>();
    if (words == null || words.length == 0) {
      return "";
    } else if (words.length == 1) {
      return words[0];
    } else {
      for(String s: words) {
        for(char c : s.toCharArray()) {
          prevCharacterCounts.put(c, 0);
        }
      }
      for (int i = 0; i < words.length - 1; ++i) {
        char[] small = words[i].toCharArray();
        char[] big = words[i + 1].toCharArray();
        int min = Math.min(small.length, big.length);
        for (int j = 0; j < min; ++j) {
          if (small[j] != big[j]) {
            Set<Character> children = smallToChildren.getOrDefault(small[j], new HashSet<>());
            if (children.add(big[j])) {
              prevCharacterCounts.put(big[j], prevCharacterCounts.get(big[j]) + 1);
            }
            smallToChildren.put(small[j], children);
            break;
          }
        }
      } // end of i loop

      Queue<Character> queue = new ArrayDeque<>();

      for (Map.Entry<Character, Integer> entry : prevCharacterCounts.entrySet()) {
        char key = entry.getKey();
        int count = entry.getValue();
        if (count == 0) queue.add(key);
      }
      StringBuilder sb = new StringBuilder();
      while (!queue.isEmpty()) {
        char curChar = queue.poll();
        sb.append(curChar);
        if (smallToChildren.containsKey(curChar)) {
          for (char child : smallToChildren.get(curChar)) {
            int prevCount = prevCharacterCounts.get(child);
            if (prevCount == 1) {
              queue.add(child);
            }
            prevCharacterCounts.put(child, prevCount - 1);
          }
        }
      }
      return sb.length() == prevCharacterCounts.size() ? sb.toString() : "";
    }

  }

}
