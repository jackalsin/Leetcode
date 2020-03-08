package _0601_0650._630_Course_Schedule_III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class SolutionI implements Solution {
  /**
   * https://leetcode.com/problems/course-schedule-iii/discuss/104845/Short-Java-code-using-PriorityQueue
   *
   * @param courses
   * @return
   */
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        return Integer.compare(a[1], b[1]);
      }
    });
    // maintain a pq which contains all the course I can attend
    final Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(final Integer a, final Integer b) {
        return Integer.compare(b, a);
      }
    });
    int days = 0;
    for (int[] c : courses) {
      final int t = c[0], end = c[1];
      days += t;
      queue.add(t);
      /*
       * if it exceeds the total time it allows, 扔掉时间最长的一个课，这样可以保证更多的room给未来的课程
       */
      if (days > end) {
        days -= queue.remove();
      }
    }
    return queue.size();
  }
}
