package _701_750._734_Sentence_Similarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/4/2018.
 */
public class Solution {
  public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    final Map<String, Set<String>> map = new HashMap<>();
    for (final String[] pair : pairs) {
      final Set<String> pair0 = map.getOrDefault(pair[0], new HashSet<>());
      pair0.add(pair[1]);
      map.put(pair[0], pair0);

//      final Set<String> pair1 = map.getOrDefault(pair[1], new HashSet<>());
//      pair0.add(pair[0]);
//      map.put(pair[1], pair1);
    }
    if (words1.length != words2.length) {
      return false;
    }
    for (int i = 0; i < words1.length; i++) {
      if (
          !(words1[i].equals(words2[i])
              || (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]))
              || (map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])))
          ) {
        return false;
      }
    }
    return true;
  }
}
