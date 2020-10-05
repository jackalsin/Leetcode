package airbnb.lowestCommonAncestors;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
public final class SolutionII implements Solution {

  private final Map<String, Set<String>> childToParents = new HashMap<>();

  /**
   * 这个是BFS 考虑loop
   * 这个解法space complexity 有问题，同一个parent可能被放多遍，这题只能正着建tree
   *
   * @param words
   */
  public SolutionII(final String[][] words) {
    for (String[] line : words) {
      final String parent = line[0];
      for (int i = 1; i < line.length; i++) {
        // check if has duplicate
        final Set<String> occur = new HashSet<>();
        boolean hasDup = false;
        for (String w : line) {
          if (occur.contains(w)) {
            hasDup = true;
          }
          occur.add(w);
        }

        if (hasDup) {
          for (String w : occur) {
            childToParents.computeIfAbsent(w, key -> new HashSet<>()).addAll(occur);
          }
          break; // break the for loop
        }

        childToParents.computeIfAbsent(line[i], key -> new HashSet<>()).add(parent);
      }
    } // end of line
  }

  public String commonAncestors(String word1, String word2) {
    final Set<String> ans1 = new HashSet<>(), cycle1 = new HashSet<>();

    dfs(cycle1, ans1, word1, new HashMap<>(), new ArrayList<>());
    if (word2.equals(word1)) {
      return word1;
    }

    if (cycle1.contains(word2)) {
      return null;
    }
    final Set<String> visited2 = new HashSet<>();
    final Queue<String> q2 = new ArrayDeque<>() {{
      add(word2);
    }};
    while (!q2.isEmpty()) {
      final String toRemove = q2.remove();
      final Set<String> next = childToParents.getOrDefault(toRemove, new HashSet<>());
      for (String n : next) {
        if (visited2.contains(n)) continue;
        visited2.add(n);
        q2.add(n);
        if (ans1.contains(n)) {
          return n;
        }
        if (cycle1.contains(n)) {
          return n;
        }
      }
    }
    return null;
  }

  private void dfs(final Set<String> cycle, final Set<String> ans, final String start, final Map<String, Integer> visited, final List<String> curPath) {
    final Set<String> candidates = childToParents.getOrDefault(start, new HashSet<>());
    ans.addAll(candidates);
    for (String w : candidates) {
      if (visited.containsKey(w)) {
        for (int i = visited.get(w); i < curPath.size(); i++) {
          ans.remove(curPath.get(i));
          cycle.add(curPath.get(i));
        }
        continue;
      }

      visited.put(w, curPath.size());
      curPath.add(w);
      dfs(cycle, ans, w, visited, curPath);
      visited.remove(w);
      curPath.remove(curPath.size() - 1);
    }
  }
}
