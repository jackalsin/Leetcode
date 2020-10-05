package _0851_0900._855_Exam_Room;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class ExamRoomII implements ExamRoom {
  private final int N;
  private final Map<Integer, Interval> startMap = new HashMap<>(),
      endMap = new HashMap<>();
  private final TreeSet<Interval> intervals = new TreeSet<>(
      (a, b) -> {
        final int lenCmp = Integer.compare(b.dist, a.dist);
        if (lenCmp != 0) {
          return lenCmp;
        }
        return Integer.compare(a.start, b.start);
      });

  public ExamRoomII(final int N) {
    this.N = N;
    intervals.add(new Interval(-1, N));
  }

  public int seat() {
    final Interval toRemove = intervals.first();
    removeInterval(toRemove);
    final int left = toRemove.start, right = toRemove.end, result = toRemove.seat;
    if (left < result) {
      final Interval toAdd = new Interval(left, result);
      addInterval(toAdd);
    }
    if (result < right) {
      final Interval toAdd = new Interval(result, right);
      addInterval(toAdd);
    }
    return result;
  }

  public void leave(int p) {
    final Interval prev = endMap.get(p),
        after = startMap.get(p);
    removeInterval(prev);
    removeInterval(after);
    final Interval toAdd = new Interval(prev.start, after.end);
    addInterval(toAdd);
  }

  private void addInterval(final Interval interval) {
    startMap.put(interval.start, interval);
    endMap.put(interval.end, interval);
    intervals.add(interval);
  }

  private void removeInterval(final Interval interval) {
    startMap.remove(interval.start);
    endMap.remove(interval.end);
    intervals.remove(interval);
  }

  private final class Interval {
    private final int start, end, seat, dist;

    private Interval(int start, int end) {
      this.start = start;
      this.end = end;
      if (start == -1) {
        this.seat = 0;
        this.dist = end;
      } else if (end == N) {
        this.seat = N - 1;
        this.dist = seat - start;
      } else {
        this.seat = start + (end - start) / 2;
        this.dist = Math.min(seat - start, end - seat);
      }
    }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          ", seat=" + seat +
          ", dist=" + dist +
          '}';
    }
  }
}
