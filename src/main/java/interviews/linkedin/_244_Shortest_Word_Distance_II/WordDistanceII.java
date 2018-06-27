package interviews.linkedin._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class WordDistanceII implements WordDistance {

  private final Map<String, List<Integer>> invertedIndex = new HashMap<>();

  public WordDistanceII(String[] words) {
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      final List<Integer> index = invertedIndex.getOrDefault(word, new ArrayList<>());
      index.add(i);
      invertedIndex.put(word, index);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> i1 = invertedIndex.get(word1),
        i2 = invertedIndex.get(word2);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0, j = 0; i < i1.size() && j < i2.size(); ) {
      minDiff = Math.min(Math.abs(i1.get(i) - i2.get(j)), minDiff);
      if (i1.get(i) > i2.get(j)) {
        j++;
      } else {
        i++;
      }
    }
    return minDiff;
  }
}
