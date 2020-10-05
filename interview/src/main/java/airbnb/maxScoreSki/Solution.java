package airbnb.maxScoreSki;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
public final class Solution {
  /**
   * @param edges     [src, dst, score]
   * @param nodeScore [node, score]
   * @param src       start point
   * @return
   */
  public int maxScore(final String[][] edges, final String[][] nodeScore, final String src) {
    final Map<String, Map<String, Integer>> srcToDstToScore = new HashMap<>();
    final Map<String, Integer> nodeScores = getNodeScores(nodeScore);
    for (final String[] e : edges) {
      final String s = e[0], d = e[1];
      final int score = Integer.valueOf(e[2]);
      srcToDstToScore.computeIfAbsent(s, k -> new HashMap<>()).put(d, score);
    }

    // get indegree count
    final Map<String, Integer> indegreeCount = getIndegreeCount(srcToDstToScore, src);
    final Map<String, Integer> pointToMaxScore = new HashMap<>();
    final Queue<String> q = new ArrayDeque<>();
    q.add(src);
    pointToMaxScore.put(src, 2 * nodeScores.get(src));
    int maxScore = pointToMaxScore.get(src);
    while (!q.isEmpty()) {
      final String toRemove = q.remove();
      final int curMaxScore = pointToMaxScore.get(toRemove);
      final Map<String, Integer> nextToScore = srcToDstToScore.getOrDefault(toRemove, new HashMap<>());
      for (Map.Entry<String, Integer> e : nextToScore.entrySet()) {
        final String next = e.getKey();
        final int nextEdgeScore = e.getValue(), nextNodeScore = nodeScores.get(next),
            nextScore = getScore(nextNodeScore, nextEdgeScore), nextMaxScore = nextScore + curMaxScore;
        maxScore = Math.max(maxScore, nextMaxScore);
        // overflow
        pointToMaxScore.put(next, Math.max(pointToMaxScore.getOrDefault(next, 0), nextMaxScore));
        // debug
        final int nextIndegree = indegreeCount.get(next);
        if (nextIndegree == 1) {
          indegreeCount.remove(next);
          q.add(next);
        } else {
          indegreeCount.put(next, nextIndegree - 1);
        }
      }
    }
    return maxScore;
  }

  private static Map<String, Integer> getNodeScores(final String[][] nodeScore) {
    final Map<String, Integer> result = new HashMap<>();
    for (String[] n : nodeScore) {
      result.put(n[0], Integer.parseInt(n[1]));
    }
    return result;
  }

  private static int getScore(final int nodeScore, final int edgeScore) {
    return 2 * nodeScore + edgeScore;
  }

  /**
   * 统计只有从<tt>src</tt>出发的indegree
   *
   * @param srcToDstToScore
   * @param src
   * @return
   */
  private Map<String, Integer> getIndegreeCount(Map<String, Map<String, Integer>> srcToDstToScore, String src) {
    final Map<String, Integer> result = new HashMap<>();
    final Queue<String> q = new ArrayDeque<>();
    final Set<String> visited = new HashSet<>();
    q.add(src);
    result.put(src, 0);
    while (!q.isEmpty()) {
      final String toRemove = q.remove();
      result.put(toRemove, result.getOrDefault(toRemove, 0) + 1);
      if (visited.contains(toRemove) || !srcToDstToScore.containsKey(toRemove)) continue;
      visited.add(toRemove);
      final Set<String> next = srcToDstToScore.get(toRemove).keySet();
      q.addAll(next);
    }
    return result;
  }
}
