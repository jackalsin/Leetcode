package _201_250._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
public class WordDistance {
  private final Map<String, List<Integer>> index = new HashMap<>();

  public WordDistance(String[] words) {
    for (int i = 0; i < words.length; ++i) {
      List<Integer> prev = index.getOrDefault(words[i], new ArrayList<>());
      prev.add(i);
    }
  }

  public int shortest(String word1, String word2) {
    int result = Integer.MIN_VALUE;
    List<Integer> index1 = index.get(word1);
    List<Integer> index2 = index.get(word2);
    int indexP1 = index1.get(0), indexP2 = index2.get(0);
    while (indexP1 < index1.size() || indexP2 < index2.size()) {

      if (indexP1 == index1.size() && indexP2 < index2.size()) {
        indexP2++;
      } else if(indexP1 < index1.size() && indexP2 == index2.size()) {
        indexP1++;
      } else if (indexP1 < index1.size() && indexP2 < index2.size()) {
        if (indexP1 < indexP2) {
          result = Math.min(result, Math.abs(indexP1 - indexP2));
          indexP1++;
        } else if (indexP1 > indexP2) {
          result = Math.min(result, Math.abs(indexP1 - indexP2));
          indexP2++;
        } else {
          throw new IllegalStateException("p1 == p2, " + indexP1);
        }
      }

    }
    return result;
  }
}
