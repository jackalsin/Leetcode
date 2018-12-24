package interviews.uber._253_Meeting_Rooms_II;

import utils.Interval;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public final class SolutionI implements Solution {
  public int minMeetingRooms(Interval[] intervals) {
    final TreeMap<Interval, Integer> map = new TreeMap<>(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.end, o2.end);
      }
    });
    int minMeetingRoom = 0;
    map.put(new Interval(0, Integer.MAX_VALUE), 0);
    for (Interval i : intervals) {
      i.end--; // make inclusive
      final Map<Interval, Integer> tailMap = new TreeMap<>(map.tailMap(
          new Interval(i.start, i.start)));
      for (Map.Entry<Interval, Integer> e : tailMap.entrySet()) {
        final Interval interval = e.getKey();
        final int count = e.getValue();
        if (interval.start > i.end) break;

        final int intervalStart = interval.start, intervalEnd = interval.end,
            iStart = i.start, iEnd = i.end;
        map.remove(interval);

        if (intervalStart < iStart) {
          map.put(new Interval(intervalStart, iStart - 1), count);
        }
        if (iEnd < intervalEnd) {
          map.put(new Interval(iEnd + 1, intervalEnd), count);
        }
        // i.start <= interval.start && interval.end <= i.end;
        map.put(new Interval(Math.max(iStart, intervalStart), Math.min(iEnd, intervalEnd)), count + 1);
        minMeetingRoom = Math.max(minMeetingRoom, count + 1);
      }
    }
    return minMeetingRoom;
  }
}
