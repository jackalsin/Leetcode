package _701_750._729_My_Calendar_I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
 * <p>
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 * <p>
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
 * <p>
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation:
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 * Note:
 * <p>
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class MyCalendar {

  /*Sorted by start time*/
  private final List<Interval> appointments;

  public MyCalendar() {
    appointments = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    final Interval toInsert = new Interval(start, end);
    int insertIndex = Collections.binarySearch(appointments, toInsert);
    if (insertIndex < 0) {
      insertIndex = -insertIndex - 1;
    } else {
      return false;
    }
    if (insertIndex != 0 && appointments.get(insertIndex - 1).end > start) {
      return false;
    }
    if (insertIndex <= appointments.size() - 1 && appointments.get(insertIndex).start < end) {
      return false;
    }
    appointments.add(insertIndex, toInsert);
    return true;
  }

  private static final class Interval implements Comparable<Interval> {
    private final int start, end;


    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }


    @Override
    public int compareTo(Interval o) {
      return Integer.compare(start, o.start);
    }
  }
}
