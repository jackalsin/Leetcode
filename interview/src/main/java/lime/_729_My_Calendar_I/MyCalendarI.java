package lime._729_My_Calendar_I;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/13/2021
 */
public final class MyCalendarI implements MyCalendar {
  private final TreeMap<Integer, Integer> meetings = new TreeMap<>();

  public boolean book(int start, int end) {
    final Map.Entry<Integer, Integer> floor = meetings.floorEntry(start),
        ceiling = meetings.ceilingEntry(start);
    if (floor != null && start <= floor.getValue()) return false;
    if (ceiling != null && ceiling.getKey() <= end - 1) return false;
    meetings.put(start, end - 1);
    return true;
  }
}
