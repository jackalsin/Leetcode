package _0751_0800._756_Pyramid_Transition_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/11/2019.
 */
public final class NaiveSolution implements Solution {
  public boolean pyramidTransition(String bottom, List<String> allowed) {
    final Map<String, List<Character>> map = new HashMap<>();
    for (String word : allowed) {
      map.computeIfAbsent(word.substring(0, 2), k -> new ArrayList<>()).add(word.charAt(2));
    }
    final Set<String> candidates = new HashSet<>();
    candidates.add(bottom);
    return bfs(map, candidates);
  }

  private boolean bfs(Map<String, List<Character>> map, Set<String> candidates) {
    if (candidates.isEmpty()) {
      return false;
    }
    for (String cand : candidates) {
      if (cand.length() == 1) {
        return true;
      }
      break;
    }

    Set<String> nextCandidates = new HashSet<>();
    candiLoop:
    for (String candidate : candidates) {
      List<String> cur = new ArrayList<>();
      cur.add("");
      for (int i = 0; i + 1 < candidate.length(); i++) {
        final List<Character> nextOptions = map.get(candidate.substring(i, i + 2));
        if (nextOptions == null) {
          continue candiLoop;
        }
        List<String> nextCur = new ArrayList<>();
        for (String c : cur) {
          for (char nextOp : nextOptions) {
            nextCur.add(c + nextOp);
          }
        }
        cur = nextCur;
      }
      nextCandidates.addAll(cur);
    }
    return bfs(map, nextCandidates);
  }

}
