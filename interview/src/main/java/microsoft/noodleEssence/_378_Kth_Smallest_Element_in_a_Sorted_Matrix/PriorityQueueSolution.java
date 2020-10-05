package microsoft.noodleEssence._378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Based on the analysis, the worst case can be O(N^2 * log N)
 */
public final class PriorityQueueSolution implements Solution {
  @Override
  public int kthSmallest(int[][] matrix, int k) {
    final int n = matrix.length;
    final Queue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });

    // N * logN
    for (int col = 0; col < n; col++) {
      pq.add(new Cell(0, col, matrix[0][col]));
    }

    // k * logN
    for (int i = 0; i < k - 1; i++) {
      final Cell toRemove = pq.remove();
      if (toRemove.row == n - 1) continue;
      final int row = toRemove.row + 1, col = toRemove.col;
      pq.add(new Cell(row, col, matrix[row][col]));
    }
    return pq.remove().val;
  }


  private static final class Cell {
    private final int row, col, val;

    Cell(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }

  }
}
