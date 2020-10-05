package _1401_1450._1408_String_Matching_in_an_Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> stringMatching(String[] words) {
    final Set<String> result = new HashSet<>();
    for (int i = 0; i < words.length; ++i) {
      for (int j = 0; j < words.length; ++j) {
        if (i == j) continue;
        for (int k = 0; k < words[j].length(); k++) {
          if (words[j].startsWith(words[i], k)) {
            result.add(words[i]);
          }
        }
      }
    }
    return new ArrayList<>(result);
  }
}
