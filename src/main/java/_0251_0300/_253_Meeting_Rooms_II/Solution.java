package _0251_0300._253_Meeting_Rooms_II;

import utils.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Solution {
  public int minMeetingRooms(Interval[] intervals) {
//    return priorityQueueSolution(intervals);
    return twoArraysSolution(intervals);
  }

  private int twoArraysSolution(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; ++i) {
      starts[i] = intervals[i].start;
      ends[i] = intervals[i].end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int endIndex = 0, rooms = 0, maxRooms = 0;

    for (int startIndex = 0; startIndex < intervals.length; ++startIndex) {
      if (starts[startIndex] < ends[endIndex]) {
        rooms++;
        maxRooms = Math.max(maxRooms, rooms);
      } else {
        rooms--;
        endIndex++;
        startIndex--;
      }
    }
    return maxRooms;
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
