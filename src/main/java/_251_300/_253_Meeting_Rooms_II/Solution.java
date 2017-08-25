package _251_300._253_Meeting_Rooms_II;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

import utils.Interval;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
      }
    });
    int max = Integer.MIN_VALUE;
    Deque deque = new ArrayDeque();

    return max;
  }
}
