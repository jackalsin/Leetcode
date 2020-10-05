package tableau._243_Shortest_Word_Distance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/19/2020
 */
public final class SolutionI implements Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    if (words == null || words.length == 0) {
      return 0;
    }
    final Map<String, List<Integer>> reverseIndex = new HashMap<>();
    for (int i = 0; i < words.length; ++i) {
      reverseIndex.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
    }
    int min = Integer.MAX_VALUE;
    final List<Integer> index1 = reverseIndex.get(word1),
        index2 = reverseIndex.get(word2);
    for (int i = 0, j = 0; i < index1.size() || j < index2.size(); ) {
      final int posI = i == index1.size() ? index1.get(index1.size() - 1) : index1.get(i),
          posJ = j == index2.size() ? index2.get(index2.size() - 1) : index2.get(j);
      min = Math.min(min, Math.abs(posI - posJ));
      if (j == index2.size() || (i < index1.size() && posI < posJ)) {
        i++;
      } else {
        j++;
      }
    }
    return min;
  }
}
