package interviews.linkedin.mianjing._244_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public class WordDistance {

  private final Map<String, List<Integer>> wordIndex = new HashMap<>();

  public WordDistance(String[] words) {
    for (int i = 0; i < words.length; ++i) {
//      wordIndex.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
      if (!wordIndex.containsKey(words[i])) {
        wordIndex.put(words[i], new ArrayList<>());
      }
      wordIndex.get(words[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    final List<Integer> list1 = wordIndex.get(word1),
        list2 = wordIndex.get(word2);

    int min = Integer.MAX_VALUE;

    for (int i = 0, j = 0; i < list1.size() || j < list2.size(); ) {
      final int iVal = i == list1.size() ? list1.get(i - 1) : list1.get(i),
          jVal = j == list2.size() ? list2.get(j - 1) : list2.get(j);
      min = Math.min(min, Math.abs(jVal - iVal));

      if (i != list1.size() && j != list2.size()) {
        if (iVal < jVal) {
          i++;
        } else {
          j++;
        }
      } else if (i == list1.size()) {
        j++;
      } else {
        // j== list2.size();
        ++i;
      }

    }

    return min;
  }
}
