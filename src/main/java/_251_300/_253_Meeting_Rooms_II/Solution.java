package _251_300._253_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import utils.Interval;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    return priorityQueueSolution(intervals);
  }


  private int priorityQueueSolution(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
      }
    });
    int max = 0;
    PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.end, i2.end);
      }
    });
    int count = 0;
    while (count < intervals.length) {
      Interval interval = intervals[count];
      while (!pq.isEmpty() && pq.peek().end <= interval.start) {
        pq.poll();
      }
      pq.add(interval);
      max = Math.max(pq.size(), max);
      count++;
    }
    return max;
  }
}
