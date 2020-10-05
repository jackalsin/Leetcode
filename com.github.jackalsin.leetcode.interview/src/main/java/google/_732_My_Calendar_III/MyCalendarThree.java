package google._732_My_Calendar_III;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
public class MyCalendarThree {
  private final TreeMap<Integer, Integer> map = new TreeMap<>();

  public MyCalendarThree() {

  }

  public int book(int start, int end) {
    map.put(start, map.getOrDefault(start, 0) + 1);
    map.put(end, map.getOrDefault(end, 0) - 1);

    int res = 0, overlapped = 0;
    for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
      overlapped += entry.getValue();
      res = Math.max(res, overlapped);
    }
    return res;
  }
}
