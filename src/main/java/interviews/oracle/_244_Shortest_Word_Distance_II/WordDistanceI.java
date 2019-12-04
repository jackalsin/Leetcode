package interviews.oracle._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/2/2019
 */
public final class WordDistanceI implements WordDistance {
  private final Map<String, List<Integer>> wordToIndex = new HashMap<>();

  public WordDistanceI(String[] words) {
    for (int i = 0; i < words.length; ++i) {
      wordToIndex.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> index1 = wordToIndex.get(word1),
        index2 = wordToIndex.get(word2);
    int min = Integer.MAX_VALUE;
//    for (int i = 0, j = 0; i <= index1.size() && j <= index2.size(); ) {
    for (int i = 0, j = 0; i < index1.size() || j < index2.size(); ) {
      final int iVal = i == index1.size() ? index1.get(index1.size() - 1) : index1.get(i),
          jVal = j == index2.size() ? index2.get(index2.size() - 1) : index2.get(j);
      if (i < index1.size() && j < index2.size()) {
        if (iVal < jVal) {
          i++;
        } else {
          j++;
        }
      } else if (i < index1.size()) {
        i++;
      } else {
        ++j;
      }
      min = Math.min(min, Math.abs(jVal - iVal));
    }
    return min;
  }
}
