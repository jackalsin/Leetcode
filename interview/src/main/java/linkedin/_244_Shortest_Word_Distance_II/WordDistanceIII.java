package linkedin._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class WordDistanceIII implements WordDistance {
  private final Map<String, List<Integer>> index = new HashMap<>();

  public WordDistanceIII(String[] words) {
    for (int i = 0; i < words.length; ++i) {
      index.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
    }
  }

  @Override
  public int shortest(String word1, String word2) {
    final List<Integer> index1 = index.get(word1), index2 = index.get(word2);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0, j = 0; i < index1.size() || j < index2.size(); ) {
      int m = i == index1.size() ? index1.get(i - 1) : index1.get(i),
          n = j == index2.size() ? index2.get(j - 1) : index2.get(j);
      minDiff = Math.min(minDiff, Math.abs(m - n));
      if (i < index1.size() && j < index2.size()) {
        if (m < n) {
          i++;
        } else {
          ++j;
        }
      } else if (i < index1.size()) {
        ++i;
      } else if (j < index2.size()) {
        ++j;
      }
    }
    return minDiff;
  }
}
