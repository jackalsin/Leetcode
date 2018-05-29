package interviews.pinterest._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  /**
   * Performance: 19ms - change to string from string builder -> 12 ms
   * <p>
   * Time Complexity: O(max( unique char number, len(word) * word Len) )
   * Space Complexity: O(len(words) * len(word) )
   *
   * @param words
   * @return
   */
  public String alienOrder(String[] words) {

    // 因为要从头到位输出，所以parentToChild，但是要根据incoming degree来决定顺序，最好两个map
    final Map<Character, Set<Character>> parentToChild = new HashMap<>();
    final Map<Character, Integer> incomingDegrees = new HashMap<>();

    for (final String str : words) {
      for (char chr : str.toCharArray()) {
        incomingDegrees.put(chr, 0);
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      final String str1 = words[i], str2 = words[i + 1];
      for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
        final char c1 = str1.charAt(j), c2 = str2.charAt(j);
        if (c1 != c2) {
          final Set<Character> children = parentToChild.getOrDefault(c1, new HashSet<>());
          parentToChild.put(c1, children);

          // this way is incorrect
//          incomingDegrees.put(c2, incomingDegrees.get(c2) + 1);
          if (!children.contains(c2)) {
            incomingDegrees.put(c2, incomingDegrees.get(c2) + 1);
            children.add(c2);
          }
          break;
        }
      }
    }

    final Queue<Character> queue = new ArrayDeque<>();
//    final StringBuilder sb = new StringBuilder();
    String result = "";
    for (final Map.Entry<Character, Integer> entry : incomingDegrees.entrySet()) {
      final char chr = entry.getKey();
      if (entry.getValue() == 0) {
        queue.add(chr);
      }
    }

    while (!queue.isEmpty()) {
      final char toRemove = queue.remove();
      result += toRemove;
      final Set<Character> children = parentToChild.getOrDefault(toRemove, new HashSet<>());
      for (char chr : children) {
        incomingDegrees.put(chr, incomingDegrees.get(chr) - 1);
        if (incomingDegrees.get(chr) == 0) {
          queue.add(chr);
        }
      }
    }
//    System.out.println(sb);
    // if not enough
    if (result.length() != incomingDegrees.size()) return "";
    return result;
  }
}
