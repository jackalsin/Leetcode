package uber._290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    final Map<Character, String> charToWord = new HashMap<>();
    final Map<String, Character> wordToChar = new HashMap<>();
    final String[] words = str.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }

    for (int i = 0; i < pattern.length(); i++) {
      final char chr = pattern.charAt(i);
      if (charToWord.containsKey(chr)) {
        final String expected = charToWord.get(chr);
        if (!expected.equals(words[i])) {
          return false;
        }
      } else {
        charToWord.put(chr, words[i]);
      }
      if (wordToChar.containsKey(words[i])) {
        if (!wordToChar.get(words[i]).equals(chr)) {
          return false;
        }
      }
      wordToChar.put(words[i], chr);
    }
    return true;
  }
}
