package linkedin._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class WordDistanceIV implements WordDistance {
  private final Map<String, List<Integer>> indexList = new HashMap<>();

  public WordDistanceIV(String[] words) {
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      indexList.computeIfAbsent(word, x -> new ArrayList<>()).add(i);
    }

  }

  public int shortest(String word1, String word2) {
    final List<Integer> index1 = indexList.getOrDefault(word1, new ArrayList<>()),
        index2 = indexList.getOrDefault(word2, new ArrayList<>());
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0, j = 0; i < index1.size() || j < index2.size(); ) {
      final int i1 = i == index1.size() ? index1.get(index1.size() - 1) : index1.get(i),
          i2 = j == index2.size() ? index2.get(index2.size() - 1) : index2.get(j);
      minDiff = Math.min(minDiff, Math.abs(i1 - i2));

      if (i < index1.size() && j < index2.size()) {
        if (i1 < i2) {
          i++;
        } else {
          j++;
        }
      } else if (i == index1.size()) {
        j++;
      } else {
        i++;
      }

    }
    return minDiff;
  }
}
