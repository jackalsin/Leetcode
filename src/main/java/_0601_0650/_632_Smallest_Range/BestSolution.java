package _0601_0650._632_Smallest_Range;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/13/2020
 */
public final class BestSolution implements Solution {
  @Override
  public int[] smallestRange(List<List<Integer>> nums) {
    /*
    大致想出这样的solution并不困难，maintain一个pq，始终保持其中每一个list的一个元素，然后每次remove最小的，
    加入之后同一个list的下一个元素，直到不可以加入为止
    问题是，当有
    [4, a]
    [4, b]
    [y]
    这样的情况的时候，且，分别指向 [4, 4, y]时，如何pick最小
    结论是，无论移动谁，都没关系
    证明：
      我们先假设是始终移动a先，那么pq会经历[4, a, y], [a,b, y],但miss掉[4,b,y]的情况，does it really matter?
      1. a == b
        那么我们移动谁都没关系，[4, b, y] 会在移动[4, a, y]的时候考虑到
      2. a < b
        2.1. y < 4
            y < 4 <= a, b
            则 [4, b, y]的会产生为 [4, b],并不优于 [4, y]
        2.2. y == 4
            若 y == 4, 则 [4, 4] 为永恒最优解
        2.3. y > 4
            2.3.1. y < a <= b
            2.3.2. a = y <= b
            2.3.3. a < y < b
            2.3.3. a < y = b
              上述4种情况下，只要有 y <= b, 则 [4, b, y]只会产生[4, b]，并不优于[4, y]
            2.3.4. a <= b < y
              我们有 4<= a <= b < y, 则 [4, b, y] 产生 [4, y], 与不考虑 [4, b, y]属于等同最优解
   综上所述，考虑 [4, y, b] 属于多虑了
   */
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      //{val, list index in list, index in list}
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });
    final int size = nums.size();
    int lastVal = 0;
    for (int row = 0; row < nums.size(); row++) {
      final int val = nums.get(row).get(0);
      pq.add(new int[]{val, row, 0});
      lastVal = Math.max(lastVal, val);
    }
    final int[] res = {Integer.MIN_VALUE, Integer.MAX_VALUE};
    long maxDist = Long.MAX_VALUE;
    while (size == pq.size()) {
      final int[] toRemove = pq.remove();
      final int firstVal = toRemove[0], rowIndex = toRemove[1], colIndex = toRemove[2],
          curDist = lastVal - firstVal;
      if (curDist < maxDist) {
        maxDist = curDist;
        res[0] = firstVal;
        res[1] = lastVal;
      }
      final List<Integer> row = nums.get(rowIndex);
      final int total = row.size();
      if (colIndex + 1 == total) {
        break;
      }
      final int nextVal = row.get(colIndex + 1);
      pq.add(new int[]{nextVal, rowIndex, colIndex + 1});
      lastVal = Math.max(lastVal, nextVal);
    }
    return res;
  }
}

