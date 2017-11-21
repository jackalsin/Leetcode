package _401_450._444_Sequence_Reconstruction;

import java.util.*;

/**
 *
 */
public class Solution {
  public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    final Map<Integer, List<Integer>> graph = new HashMap<>();
    final Map<Integer, Integer> indegrees = new HashMap<>();

    // initialize
    for (final List<Integer> seq : seqs) {
      if (seq.size() == 0) continue;
      if (seq.size() == 1) {
        graph.putIfAbsent(seq.get(0), new ArrayList<>());
        indegrees.putIfAbsent(seq.get(0), 0);
      } else {
        for (int i = 0; i < seq.size() - 1; i++) {
          final int prev = seq.get(i);
          final int next = seq.get(i + 1);

          graph.putIfAbsent(prev, new ArrayList<>());
          graph.putIfAbsent(next, new ArrayList<>());
          graph.get(prev).add(next);
          indegrees.putIfAbsent(prev, 0);
          indegrees.put(next, indegrees.getOrDefault(next, 0) + 1);
        }
      }
    }

    final Queue<Integer> queue = new ArrayDeque<>();
    for (Map.Entry<Integer, Integer> indegree : indegrees.entrySet()) {
      if (indegree.getValue() == 0) {
        queue.add(indegree.getKey());
      }
    }
    int index = 0;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      if (size != 1) return false;
      index++;
      int removed = queue.poll();
      if (index == org.length || removed != org[index]) return false;
      List<Integer> candidatesForNext = graph.get(removed);
      for (int candidate : candidatesForNext) {
        indegrees.put(candidate, indegrees.get(candidate) - 1);
        if (indegrees.get(candidate) == 0) {
          queue.add(candidate);
        }
      }

    }

    return index == org.length && index == graph.size(); // check cycle
  }
}
