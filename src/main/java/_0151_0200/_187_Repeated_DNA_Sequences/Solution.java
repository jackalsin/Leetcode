package _0151_0200._187_Repeated_DNA_Sequences;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
//    return characterManipulation(s);
    return bitManipulation(s);
  }

  private static List<String> bitManipulation(String s) {
    final int[] map = new int['T' - 'A' + 1];
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;
    List<String> result = new ArrayList<>();
    Map<Integer, Integer> wordCounts = new HashMap<>();
    for(int start = 0; start + 9 < s.length(); ++start) {
      int curNum = 0;
      for (int i = 0; i < 10; i++) {
        curNum <<= 2;
        curNum = curNum | map[s.charAt(start + i) - 'A'];
      }
      int counts = wordCounts.getOrDefault(curNum, 0);
      if (counts == 1) {
        result.add(s.substring(start, start + 10));
      }
      wordCounts.put(curNum, counts + 1);
    }

    return result;
  }

  private List<String> characterManipulation(String s) {
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
