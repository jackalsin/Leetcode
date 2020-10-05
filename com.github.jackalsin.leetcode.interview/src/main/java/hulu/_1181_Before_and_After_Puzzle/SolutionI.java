package hulu._1181_Before_and_After_Puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class SolutionI implements Solution {
  private final Map<String, List<Integer>> headMap = new HashMap<>(),
      tailMap = new HashMap<>();
  private final Map<String, Integer> count = new HashMap<>();

  public List<String> beforeAndAfterPuzzles(String[] phrases) {
    final Set<String> result = new HashSet<>();
    if (phrases == null || phrases.length == 0) {
      return new ArrayList<>(result);
    }

    for (int i = 0; i < phrases.length; i++) {
      final String[] items = phrases[i].split(" ");
      headMap.computeIfAbsent(items[0], k -> new ArrayList<>()).add(i);
      tailMap.computeIfAbsent(items[items.length - 1], k -> new ArrayList<>()).add(i);
      count.put(phrases[i], count.getOrDefault(phrases[i], 0) + 1);
    }

    for (final Map.Entry<String, List<Integer>> first : tailMap.entrySet()) {
      final String connect = first.getKey();
      final List<Integer> seconds = headMap.get(connect);
      if (seconds == null) {
        continue;
      }
      for (int f : first.getValue()) {
        final String firstWord = phrases[f];
        final int len = phrases[f].length() - connect.length();
        for (final int second : seconds) {
          final String secondWord = phrases[second];
          if (secondWord.equals(firstWord) && count.get(secondWord) == 1) {
            continue;
          }
          final StringBuilder sb = new StringBuilder(firstWord);
          sb.setLength(len);
          sb.append(phrases[second]);
          result.add(sb.toString());
        }
      }
    }

    final List<String> rtn = new ArrayList<>(result);
    Collections.sort(rtn);
    return rtn;
  }
}
