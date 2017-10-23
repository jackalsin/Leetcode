package interviews.linkedin._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class WordDistance {

  private final Map<String, List<Integer>> index;

  public WordDistance(String[] words) {
    index = new HashMap<>();
    for (int i = 0; i < words.length; ++i) {
      index.putIfAbsent(words[i], new ArrayList<>());
      index.get(words[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> index1 = index.get(word1);
    final List<Integer> index2 = index.get(word2);
    int i = 0, j = 0, minDistance = Integer.MAX_VALUE;
    while (i < index1.size() || j < index2.size()) {
      if (i == index1.size()) {
        minDistance = Math.min(minDistance, Math.abs(index1.get(i - 1) - index2.get(j++)));
      } else if (j == index2.size()) {
        minDistance = Math.min(minDistance, Math.abs(index1.get(i++) - index2.get(j - 1)));
      } else {
        if (index1.get(i) < index2.get(j)) {
          minDistance = Math.min(minDistance, Math.abs(index1.get(i++) - index2.get(j)));
        } else {
          minDistance = Math.min(minDistance, Math.abs(index1.get(i) - index2.get(j++)));
        }
      }
    }
    return minDistance;
  }
}
