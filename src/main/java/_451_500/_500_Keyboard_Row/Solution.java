package _451_500._500_Keyboard_Row;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  private static final Set<Set<Character>> ALL_CANDIDATES = new HashSet<>();

  static {
    final Set<Character> row1 = new HashSet<>();
    for (char chr : "qwertyuiop".toCharArray()) {
      row1.add(chr);
      row1.add(Character.toUpperCase(chr));
    }
    ALL_CANDIDATES.add(row1);

    final Set<Character> row2 = new HashSet<>();
    for (char chr : "asdfghjkl".toCharArray()) {
      row2.add(chr);
      row2.add(Character.toUpperCase(chr));
    }
    ALL_CANDIDATES.add(row2);

    final Set<Character> row3 = new HashSet<>();
    for (char chr : "zxcvbnm".toCharArray()) {
      row3.add(chr);
      row3.add(Character.toUpperCase(chr));
    }
    ALL_CANDIDATES.add(row3);
  }

  /**
   * 22 / 22 test cases passed.
   * Status: Accepted
   * Runtime: 4 ms
   *
   * @param words
   * @return
   */
  public String[] findWords(String[] words) {
    final List<String> result = new ArrayList<>();
    nextWord:
    for (final String word : words) {
      if (word.isEmpty()) continue;
      Set<Character> cur = null;
      // find the target set.
      for (final Set<Character> child : ALL_CANDIDATES) {
        if (child.contains(word.charAt(0))) {
          cur = child;
          break;
        }
      }
      if (cur == null) { // not valid keyboard
        continue;
      }
      for (char chr : word.toCharArray()) {
        if (!cur.contains(chr)) {
          continue nextWord; // go to nextWord
        }
      }
      result.add(word);
    }

    // Convert to array
    final String[] res = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      res[i] = result.get(i);
    }
    return res;
  }
}
