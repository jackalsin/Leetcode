package _601_650._630_Course_Schedule_III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        return Integer.compare(a[1], b[1]);
      }
    });

    final Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(final Integer a, final Integer b) {
        return Integer.compare(b, a);
      }
    });
    int days = 0, count = 0;
    for (int[] c : courses) {
      final int t = c[0], end = c[1];
      days += t;
      queue.add(t);
      count++;
      if (days > end) {
        days -= queue.remove();
        count--;
      }
    }
    return count;
  }
}
