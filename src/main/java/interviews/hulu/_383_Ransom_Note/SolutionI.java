package interviews.hulu._383_Ransom_Note;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canConstruct(String ransomNote, String magazine) {
    final Map<Character, Integer> charCount = new HashMap<>();
    for (char chr : magazine.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }

    for (final char chr : ransomNote.toCharArray()) {
      if (!charCount.containsKey(chr)) return false;
      final int count = charCount.get(chr);
      if (count <= 0) {
        return false;
      }
      charCount.put(chr, count - 1);
    }
    return true;
  }
}
