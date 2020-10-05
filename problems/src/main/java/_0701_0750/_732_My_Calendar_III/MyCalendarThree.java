package _0701_0750._732_My_Calendar_III;

import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 1/4/2018.
 */
public final class MyCalendarThree {
  private final TreeMap<Integer, Integer> events = new TreeMap<>();

  public MyCalendarThree() {

  }

  public int book(int start, int end) {
    events.put(start, events.getOrDefault(start, 0) + 1);
    events.put(end, events.getOrDefault(end, 0) - 1);
    int max = 0, ongoing = 0;
    for (int count : events.values()) {
      ongoing += count;
      max = Math.max(max, ongoing);
    }
    return max;
  }
}
