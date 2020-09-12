package _0851_0900._855_Exam_Room;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 2/21/2019.
 */
public final class ExamRoomI implements ExamRoom {
  private int N;
  private Map<Integer, List<Integer>> startMap = new HashMap<>(), endMap = new HashMap<>();

  /**
   * store all the intervals
   */
  private final TreeSet<List<Integer>> intervals = new TreeSet<>(new Comparator<List<Integer>>() {

    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
      final int distA = dist(o1), distB = dist(o2);
      final int cmp = Integer.compare(distB, distA);
      if (cmp == 0) {
        return Integer.compare(o1.get(0), o2.get(0));
      }
      return cmp;
    }
  });

  public ExamRoomI(int N) {
    this.N = N;
    addInterval(Arrays.asList(-1, N));
  }

  public int seat() {
    final List<Integer> interval = intervals.pollFirst();
    int seat = 0;
    if (interval.get(0) == -1) {
      seat = 0;
    } else if (interval.get(1) == N) {
      seat = N - 1;
    } else {
      seat = interval.get(0) + (interval.get(1) - interval.get(0)) / 2;
    }

    final List<Integer> left = Arrays.asList(interval.get(0), seat),
        right = Arrays.asList(seat, interval.get(1));
    addInterval(left);
    addInterval(right);
    return seat;
  }

  public void leave(int p) {
    final List<Integer> left = endMap.get(p), right = startMap.get(p),
        merged = Arrays.asList(left.get(0), right.get(1));
    removeInterval(left);
    removeInterval(right);
    addInterval(merged);
  }

  private void addInterval(final List<Integer> interval) {
    intervals.add(interval);
    startMap.put(interval.get(0), interval);
    endMap.put(interval.get(1), interval);
  }

  private void removeInterval(final List<Integer> interval) {
    intervals.remove(interval);
    startMap.remove(interval.get(0));
    endMap.remove(interval.get(1));
  }


  private int dist(final List<Integer> i) {
    if (i.get(0) == -1) {
      return i.get(1);
    }
    if (i.get(1) == N) {
      return N - 1 - i.get(0);
    }
    // only consider the one that is closest, so divide by 2
    return (i.get(1) - i.get(0)) / 2;
  }
}
