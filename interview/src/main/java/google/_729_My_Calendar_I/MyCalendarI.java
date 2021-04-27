package google._729_My_Calendar_I;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/26/2021
 */
public final class MyCalendarI implements MyCalendar {
  private final TreeMap<Integer, Integer> intervals = new TreeMap<>();

  public boolean book(int start, int end) {
    final Map.Entry<Integer, Integer> prev = intervals.floorEntry(start),
        next = intervals.ceilingEntry(start);
    if (prev != null && prev.getValue() >= start) {
      return false;
    }
    if (next != null && next.getKey() <= end - 1) {
      return false;
    }
    intervals.put(start, end - 1);
    return true;
  }
}
