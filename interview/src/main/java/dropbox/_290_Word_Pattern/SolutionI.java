package dropbox._290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/22/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean wordPattern(String pattern, String s) {
    final Map<String, Character> reverse = new HashMap<>();
    final Map<Character, String> inorder = new HashMap<>();
    final String[] words = s.split("\\s");
    if (words.length != pattern.length()) return false;
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      final char chr = pattern.charAt(i);
      final String expectedStr = inorder.get(chr);
      final Character expectedChr = reverse.get(word);
      if (inorder.containsKey(chr) && reverse.containsKey(word)) {
        if (!word.equals(expectedStr) || expectedChr != chr) return false;
      } else if (inorder.containsKey(chr) || reverse.containsKey(word)) {
        return false;
      } else {
        inorder.put(chr, word);
        reverse.put(word, chr);
      }
    }
    return true;
  }
}
