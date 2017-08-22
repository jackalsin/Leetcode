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
      index.put(words[i], prev);
    }
  }

  public int shortest(String word1, String word2) {
    int result = Integer.MAX_VALUE;
    List<Integer> index1s = index.get(word1);
    List<Integer> index2s = index.get(word2);
    for(int i = 0, j = 0; i < index1s.size() && j < index2s.size();) {
      final int index1 = index1s.get(i), index2 = index2s.get(j);
      result = Math.min(result, Math.abs(index1 - index2));
      if (index1 < index2) {
        i++;
      } else if (index1 > index2) {
        j++;
      } else {
        throw new IllegalStateException("p1 == p2, " + i);
      }
    }
    return result;
  }

  public int shortestNotOptimal(String word1, String word2) {
    int result = Integer.MAX_VALUE;
    List<Integer> index1s = index.get(word1);
    List<Integer> index2s = index.get(word2);
    for(int i = 0, j = 0; i < index1s.size() || j < index2s.size();) {
      final int index1 = index1s.get(i), index2 = index2s.get(j);
      if (i == index1s.size() - 1 && j < index2s.size()) {
        result = Math.min(result, Math.abs(index1 - index2));
        j++;
      } else if(i < index1s.size() && j == index2s.size() - 1) {
        result = Math.min(result, Math.abs(index1 - index2));
        i++;
      } else if (i < index1s.size() && j < index2s.size()) {
        if (index1 < index2) {
          result = Math.min(result, Math.abs(index1 - index2));
          i++;
        } else if (index1 > index2) {
          result = Math.min(result, Math.abs(index1 - index2));
          j++;
        } else {
          throw new IllegalStateException("p1 == p2, " + i);
        }
      }

    }

    return result;
  }
}
