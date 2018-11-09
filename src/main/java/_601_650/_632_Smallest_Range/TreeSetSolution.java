package _601_650._632_Smallest_Range;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

public final class TreeSetSolution implements Solution {
  private final TreeSet<Pair> treeset = new TreeSet<>(new Comparator<Pair>() {

    @Override
    public int compare(Pair o1, Pair o2) {
      int cmpVal = Integer.compare(o1.val, o2.val);
      if (cmpVal == 0) {
        return Integer.compare(o1.listIndex, o2.listIndex);
      }
      return cmpVal;
    }
  });

  public int[] smallestRange(List<List<Integer>> nums) {
    assert nums.size() >= 1;
    final PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    for (int i = 0; i < nums.size(); i++) {
      final List<Integer> l = nums.get(i);
      if (l.isEmpty()) continue;
      final Pair p = new Pair(l.get(0), i, 0);
      treeset.add(p);
      if (l.size() > 1) {
        pq.add(new Pair(l.get(1), i, 1));
      }
    }
    final int[] res = {treeset.first().val, treeset.last().val};

    while (!pq.isEmpty()) {
      final Pair p = pq.remove();
      treeset.remove(new Pair(nums.get(p.listIndex).get(p.index - 1), p.listIndex, p.index - 1));
      if (nums.get(p.listIndex).size() - 1 != p.index) {
        pq.add(new Pair(nums.get(p.listIndex).get(p.index + 1), p.listIndex, p.index + 1));
      }

      treeset.add(p);
      final int curSmall = treeset.first().val, curBig = treeset.last().val;
      if ((long) res[1] - (long) res[0] > (long) curBig - (long) curSmall) {
        res[0] = curSmall;
        res[1] = curBig;
      }
    }
    return res;
  }

  private static final class Pair {
    private final int val, listIndex, index;

    private Pair(int val, int listIndex, int index) {

      this.val = val;
      this.listIndex = listIndex;
      this.index = index;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return val == pair.val &&
          listIndex == pair.listIndex &&
          index == pair.index;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, listIndex, index);
    }
  }
}
