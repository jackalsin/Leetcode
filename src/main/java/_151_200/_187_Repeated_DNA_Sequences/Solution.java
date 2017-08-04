package _151_200._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> preVisited = new HashSet<>();
    Set<String> result = new HashSet<>();
    for (int i = 0; i <= s.length() - 10; ++i) {
      String sub = s.substring(i, i + 10);
      if (preVisited.contains(sub)) {
        result.add(sub);
      } else {
        preVisited.add(sub);
      }
    }
    return new ArrayList<>(result);
  }

}
