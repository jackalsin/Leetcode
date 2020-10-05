package _0801_0850._804_Unique_Morse_Code_Words;

import java.util.HashSet;
import java.util.Set;

public final class Solution {
  private static final String[] MAP = {
      ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
  };

  public int uniqueMorseRepresentations(String[] words) {
    final Set<String> allCont = new HashSet<>();

    for (final String w : words) {
      final char[] word = w.toCharArray();
      final StringBuilder sb = new StringBuilder();
      for (char chr : word) {
        sb.append(MAP[chr - 'a']);
      }
      allCont.add(sb.toString());
    }

    return allCont.size();
  }
}
