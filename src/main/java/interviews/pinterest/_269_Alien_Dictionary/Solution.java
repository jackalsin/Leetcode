package interviews.pinterest._269_Alien_Dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution { // TODO:

  public String alienOrder(String[] words) {

    // 因为要从头到位输出，所以parentToChild，但是要根据incoming degree来决定顺序，最好两个map
    final Map<Character, Set<Character>> parentToChild = new HashMap<>();

    for (final String str : words) {
      for (char chr : str.toCharArray()) {
        parentToChild.put(chr, new HashSet<>());
      }
    }

    final int expectedLength = parentToChild.size();

    for (int i = 0; i < words.length - 1; i++) {
      final String str1 = words[i], str2 = words[i + 1];
      for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
        if (str1.charAt(j) != str2.charAt(j)) {
          parentToChild.get(str1.charAt(j)).add(str2.charAt(j));
          break;
        }
      }
    }

    final Queue<Character> queue = new ArrayDeque<>();
    final boolean[] visited = new boolean[128];
    final StringBuilder sb = new StringBuilder();
    for (final Map.Entry<Character, Set<Character>> entry : parentToChild.entrySet()) {
      final char chr = entry.getKey();
      if (entry.getValue().isEmpty() && !visited[chr]) {
        visited[chr] = true;
        queue.add(chr);
      }
    }

    while (!queue.isEmpty()) {
      final char toRemove = queue.remove();
      sb.append(toRemove);
      final Set<Character> children = parentToChild.get(toRemove);
      for (char chr : children) {
        if (!visited[chr]) {
          visited[chr] = true;
          queue.add(chr);
        }
      }
    }

    System.out.println(sb);
    // if not enough
    if (sb.length() != expectedLength) return "";
    return sb.toString();
  }
}
