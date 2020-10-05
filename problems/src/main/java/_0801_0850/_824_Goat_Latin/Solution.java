package _0801_0850._824_Goat_Latin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
  private static final Set<Character> VOWEL = new HashSet<>(
      Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
  );

  public String toGoatLatin(String S) {
    int wordCount = 0;
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      final char chr = S.charAt(i);
      if (chr == ' ') {
        sb.append(' ');
      } else {
        wordCount++;
        int start = i;
        while (i + 1 < S.length() && S.charAt(i + 1) != ' ') {
          i++;
        }
        String word = S.substring(start, i + 1);
        if (VOWEL.contains(chr)) {
          sb.append(word);
        } else {
          sb.append(word.substring(1)).append(word.charAt(0));
        }

        sb.append("ma");
        // append a
        for (int aCount = 0; aCount < wordCount; aCount++) {
          sb.append('a');
        }
      }

    }
    return sb.toString();
  }

}
