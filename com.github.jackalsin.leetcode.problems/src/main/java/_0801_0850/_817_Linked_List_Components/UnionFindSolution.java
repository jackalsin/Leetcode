package _0801_0850._817_Linked_List_Components;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public final class UnionFindSolution implements Solution {
  public int numComponents(ListNode head, int[] G) {
    final UnionFind uf = new UnionFind(G);
    ListNode cur = head;
    while (cur.next != null) {
      uf.union(cur.val, cur.next.val);
      cur = cur.next;
    }

    return uf.counts;
  }

  private static final class UnionFind {
    private int counts;
    private final int[] roots, size;

    private final Map<Integer, Integer> valToIndex = new HashMap<>();

    private UnionFind(final int[] G) {
      roots = new int[G.length];
      size = new int[G.length];
      for (int i = 0; i < G.length; i++) {
        valToIndex.put(G[i], i);
        roots[i] = i;
        size[i] = 1;
      }
      counts = G.length;
    }

    private void union(final int pVal, final int qVal) {
      if (!valToIndex.containsKey(pVal) || !valToIndex.containsKey(qVal)) return;
      final int rootP = root(pVal), rootQ = root(qVal),
          sizeP = size[rootP], sizeQ = size[rootQ];
      if (rootP == rootQ) return;
      if (sizeP > sizeQ) {
        roots[rootQ] = rootP;
        size[rootP] += sizeQ;
      } else {
        roots[rootP] = rootQ;
        size[rootQ] += sizeP;
      }
      counts--;
    }

    private int root(int pVal) {
      assert valToIndex.containsKey(pVal);
      int p = valToIndex.get(pVal);
      while (p != roots[p]) {
        p = roots[p];
      }
      return p;
    }
  }
}
