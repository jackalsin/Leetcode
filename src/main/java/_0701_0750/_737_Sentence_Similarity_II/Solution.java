package _0701_0750._737_Sentence_Similarity_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/4/2018.
 */
public class Solution {
  public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
    if (words1.length != words2.length) {
      return false;
    }
    final Map<String, String> map = new HashMap<>();

    for (final String[] word : pairs) {
      String rootP = find(map, word[0]), rootQ = find(map, word[1]);
      if (!rootP.equals(rootQ)) {
        map.put(rootP, rootQ);
      }
    }
    for (int i = 0; i < words1.length; i++) {
      if (!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i]))) {
        return false;
      }
    }
    return true;
  }

  private static String find(final Map<String, String> map, String s) {
    map.putIfAbsent(s, s);
    while (!s.equals(map.get(s))) {
      s = map.get(s);
    }
    return s;
  }
}
