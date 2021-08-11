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
  private final Map<String, List<Integer>> valToIndex = new HashMap<>();
  public WordDistanceV(String[] words) {
    if (words == null) return;
    for (int i = 0; i < words.length; ++i) {
      valToIndex.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> index1 = valToIndex.get(word1),
        index2 = valToIndex.get(word2);
    int min = Integer.MAX_VALUE;
    System.out.println(index1 + ", " + index2);
    for (int i = 0, j = 0; i < index1.size() || j < index2.size(); ) {
      final int left = i == index1.size() ? index1.get(i - 1) : index1.get(i),
          right = j == index2.size() ? index2.get(j - 1) : index2.get(j);
      min = Math.min(min, Math.abs(right - left));
      if (i == index1.size()) ++j;
      else if (j == index2.size()) ++i;
      else if (left < right) ++i;
      else ++j;
    }
    return min;
  }
}
