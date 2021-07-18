package doordash._630_Course_Schedule_III;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public final class SolutionI implements Solution {
  @Override
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
    /*all the courses I can attend*/
    final Queue<Integer> allCourses = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    int days = 0; // days to attend course
    for (final int[] course : courses) {
      final int end = course[1], t = course[0], start = course[1] - course[0];
      if (start < 0) continue;
      days += t;
      allCourses.add(t);
      if (days > end) {
        final int toRemove = allCourses.remove();
        days -= toRemove;
      }
    }
    return allCourses.size();
  }
}
