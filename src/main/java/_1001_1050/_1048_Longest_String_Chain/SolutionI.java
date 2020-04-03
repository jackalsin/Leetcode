package _1001_1050._1048_Longest_String_Chain;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int longestStrChain(String[] words) {
    if (words == null || words.length == 0) {
      return 0;
    }
    final Map<String, Integer> indegree = new HashMap<>();
    final Map<String, Set<String>> parentToChildren = new HashMap<>();
    for (final String word : words) {
      parentToChildren.put(word, new HashSet<>());
      indegree.put(word, 0);
    }
    for (final String word : words) {
      if (word.length() != 1) {
        for (int i = 0; i < word.length(); ++i) {
          final String next = word.substring(0, i) + word.substring(i + 1);
          final Set<String> children = parentToChildren.get(next);
          if (children != null) {
            if (children.add(word)) {
              indegree.put(word, indegree.get(word) + 1);
            }
          }
        }
      }
    }
//    System.out.println(parentToChildren);
//    System.out.println(indegree);
    final Queue<Pair> q = new ArrayDeque<>();
    final Map<String, Integer> maxSteps = new HashMap<>();
    for (final Map.Entry<String, Integer> e : indegree.entrySet()) {
      if (e.getValue() == 0) {
        q.add(new Pair(e.getKey(), 1));
        maxSteps.put(e.getKey(), 1);
      }
    }
    int max = 0;
    while (!q.isEmpty()) {
      final Pair toRemove = q.remove();
      final String parent = toRemove.word;
      final int parentStep = toRemove.step;
      max = Math.max(parentStep, max);
      final Set<String> children = parentToChildren.get(parent);
      for (final String c : children) {
        final int prevCount = indegree.get(c),
            currentStep = parentStep + 1;
        maxSteps.put(c, Math.max(maxSteps.getOrDefault(c, 0), currentStep));
        if (prevCount == 1) {
          final int maxStep = maxSteps.get(c);
          q.add(new Pair(c, maxStep));
        }
        indegree.put(c, indegree.get(c) - 1);
      }
    }
//    System.out.println(indegree);

    return max;
  }

  private static final class Pair {
    private final String word;
    private final int step;

    private Pair(String word, int step) {
      this.word = word;
      this.step = step;
    }
  }
}
