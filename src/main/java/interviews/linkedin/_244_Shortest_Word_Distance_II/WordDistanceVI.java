package interviews.linkedin._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/8/2019
 */
public final class WordDistanceVI implements WordDistance {
  private final Map<String, List<Integer>> wordToIndex = new HashMap<>();

  public WordDistanceVI(String[] words) {
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      if (!wordToIndex.containsKey(word)) {
        wordToIndex.put(word, new ArrayList<>());
      }
      wordToIndex.get(word).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> index1 = wordToIndex.get(word1),
        index2 = wordToIndex.get(word2);
    assert !word1.equals(word2);
    int min = Integer.MAX_VALUE;
    for (int i = 0, j = 0; i < index1.size() || j < index2.size(); ) {
      final int indexI = i == index1.size() ? index1.get(i - 1) : index1.get(i),
          indexJ = j == index2.size() ? index2.get(j - 1) : index2.get(j);
      if (j == index2.size()) {
        min = Math.min(min, Math.abs(indexJ - indexI));
        i++;
      } else if (i == index1.size()) {
        min = Math.min(min, Math.abs(indexJ - indexI));
        j++;
      } else if (indexI < indexJ) {
        min = Math.min(min, Math.abs(indexJ - indexI));
        i++;
      } else if (indexI > indexJ) {
        min = Math.min(min, Math.abs(indexJ - indexI));
        j++;
      } else {
        throw new IllegalStateException("indexI == indexJ should not happen");
      }
    }
    return min;
  }
}
