package _601_650._632_Smallest_Range;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public final class SinglePriorityQueueSolution implements Solution {
  @Override
  public int[] smallestRange(List<List<Integer>> nums) {
    final PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    assert nums.size() >= 1;
    long minRangeEnd = Integer.MIN_VALUE;
    for (int i = 0; i < nums.size(); i++) {
      final List<Integer> l = nums.get(i);
      if (l.isEmpty()) continue;
      final Pair p = new Pair(l.get(0), 0, i);
      pq.add(p);
      minRangeEnd = Math.max(p.val, minRangeEnd);
    }
    assert !pq.isEmpty();
    long minRangeStart = pq.peek().val, minRange = minRangeEnd - minRangeStart;
    final int size = pq.size();
    long curEnd = minRangeEnd;
    while (pq.size() == size) {
      final Pair p = pq.remove();
      if (p.index + 1 == nums.get(p.rowIndex).size()) break;
      final Pair nextP = new Pair(nums.get(p.rowIndex).get(p.index + 1), p.index + 1, p.rowIndex);
      pq.add(nextP);
      final long curStart = pq.peek().val;
      curEnd = Math.max(curEnd, nextP.val);
      if (curEnd - curStart < minRangeEnd - minRangeStart) {
        minRangeEnd = curEnd;
        minRangeStart = curStart;
      }
    }
    return new int[]{(int) minRangeStart, (int) minRangeEnd};
  }


  private static final class Pair {
    private final int val, index, rowIndex;

    private Pair(int val, int index, int rowIndex) {
      this.val = val;
      this.index = index;
      this.rowIndex = rowIndex;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return val == pair.val &&
          index == pair.index &&
          rowIndex == pair.rowIndex;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, index, rowIndex);
    }
  }
}
