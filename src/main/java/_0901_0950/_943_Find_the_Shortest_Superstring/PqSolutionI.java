package _0901_0950._943_Find_the_Shortest_Superstring;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/9/2020
 */
public final class PqSolutionI implements Solution {
  @Override
  public String shortestSuperstring(String[] A) {
    final int[][] graph = getGraph(A);
    final int N = A.length;
    final Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return Integer.compare(o1.distance, o2.distance);
      }
    });
    for (int i = 0; i < A.length; ++i) {
      final Node start = new Node();
      start.distance += A[i].length();
      start.list.add(i);
      start.last = i;
      pq.add(start);
    }

    while (!pq.isEmpty()) {
      final Node toRemove = pq.remove();
      if (toRemove.list.size() == A.length) {
        return getString(graph, A, toRemove.list);
      }
      for (int i = 0; i < N; i++) {
        if (toRemove.list.contains(i)) continue;
        final Node next = new Node(toRemove);
        next.list.add(i);
        next.distance += graph[toRemove.last][i];
        next.last = i;
        pq.add(next);
      }
    }
    throw new IllegalStateException();
  }

  private static String getString(final int[][] graph, final String[] a, final LinkedHashSet<Integer> list) {
//    System.out.println(list);
    final StringBuilder sb = new StringBuilder();
    int prev = 0;
    for (int i : list) {
      if (sb.length() == 0) {
        sb.append(a[i]);
      } else {
        sb.append(a[i].substring(a[i].length() - graph[prev][i]));
      }
      prev = i;
    }
    return sb.toString();
  }

  private int[][] getGraph(String[] strs) {
    final int N = strs.length;
    final int[][] res = new int[N][N];
    for (int i = 0; i < strs.length; ++i) {
      for (int j = 0; j < strs.length; ++j) {
        res[i][j] = distance(strs[i], strs[j]);
      }
    }
    return res;
  }

  private int distance(final String str1, final String str2) {
    final int len1 = str1.length(), len2 = str2.length();
    for (int overlap = str2.length(); overlap >= 0; overlap--) {
      if (str1.endsWith(str2.substring(0, overlap))) {
        return len2 - overlap;
      }
    }
    return str2.length();
  }

  private static final class Node {
    private final LinkedHashSet<Integer> list = new LinkedHashSet<>();
    private int distance = 0, last = 0;

    private Node() {
    }

    private Node(Node node) {
      this.list.addAll(node.list);
      this.distance = node.distance;
      this.last = node.last;
    }

  }
}
