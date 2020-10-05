package linkedin._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class WordDistanceV implements WordDistance {
  private final Map<String, List<Integer>> indexes = new HashMap<>();

  public WordDistanceV(String[] words) {
    if (words == null) {
      return;
    }
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      if (!indexes.containsKey(word)) {
        indexes.put(word, new ArrayList<>());
      }
      indexes.get(word).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> list1 = indexes.get(word1),
        list2 = indexes.get(word2);
    int min = Integer.MAX_VALUE;
    for (int i = 0, j = 0; i < list1.size() || j < list2.size(); ) {
      final int normalizedI = i == list1.size() ? list1.size() - 1 : i,
          normalizedJ = j == list2.size() ? list2.size() - 1 : j,
          index1 = list1.get(normalizedI),
          index2 = list2.get(normalizedJ);
      min = Math.min(min, Math.abs(index1 - index2));
      if (j == list2.size() || (i < list1.size() && index1 < index2)) {
        i++;
      } else {
        j++;
      }
    }
    return min;
  }
}
