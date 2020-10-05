package _0401_0450._433_Minimum_Genetic_Mutation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
  private static final List<Character> CHARS = new ArrayList<>();

  static {
    CHARS.add('A');
    CHARS.add('C');
    CHARS.add('T');
    CHARS.add('G');
  }

  public int minMutation(String start, String end, String[] bank) {
    final Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

    final Queue<String> queue = new ArrayDeque<>();
    queue.add(start);

    int level = 0;
    final Set<String> visited = new HashSet<>();
    visited.add(start);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        final String cur = queue.remove();
        if (end.equals(cur)) {
          return level;
        }

        final char[] chars = cur.toCharArray();
        for (int index = 0; index < chars.length; index++) {
          final char oldChar = chars[index];
          for (char toReplace : CHARS) {
            chars[index] = toReplace;
            final String next = String.valueOf(chars);
            if (!visited.contains(next) && bankSet.contains(next)) {
              visited.add(next);
              queue.add(next);
            }
          }
          chars[index] = oldChar;
        }
      }

      level++;
    }

    return -1;
  }
}
