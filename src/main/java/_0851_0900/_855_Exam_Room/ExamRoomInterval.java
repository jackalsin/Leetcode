package _0851_0900._855_Exam_Room;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 2/21/2019.
 */
public final class ExamRoomInterval {

  private final int N;
  private final Map<Integer, Interval> startMap = new HashMap<>(),
      endMap = new HashMap<>();

  private final TreeSet<Interval> intervalPq = new TreeSet<>(new Comparator<Interval>() {
    @Override
    public int compare(Interval o1, Interval o2) {
      final int cmp = Integer.compare(o2.dist, o1.dist);
      if (cmp == 0) {
        return Integer.compare(o1.start, o2.start);
      }
      return cmp;
    }
  });

  public ExamRoomInterval(int N) {
    this.N = N;
    addInterval(new Interval(-1, N));
  }

  public int seat() {
    final Interval toRemove = intervalPq.pollFirst();
    int seat = 0;
    if (toRemove.start == -1) {
      seat = 0;
    } else if (toRemove.end == N) {
      seat = N - 1;
    } else {
      seat = toRemove.start + (toRemove.end - toRemove.start) / 2;
    }
    addInterval(new Interval(toRemove.start, seat));
    addInterval(new Interval(seat, toRemove.end));
    return seat;
  }

  public void leave(int p) {
    final Interval left = endMap.get(p), right = startMap.get(p),
        merged = new Interval(left.start, right.end);
    removeInterval(left);
    removeInterval(right);
    addInterval(merged);
  }

  private void addInterval(final Interval i) {
    intervalPq.add(i);
    startMap.put(i.start, i);
    endMap.put(i.end, i);
  }

  private void removeInterval(final Interval i) {
    intervalPq.remove(i);
    startMap.remove(i.start);
    endMap.remove(i.end);
  }

  private final class Interval {
    private final int start, end, dist;

    private Interval(final int start, final int end) {
      this.start = start;
      this.end = end;
      if (start == -1) {
        this.dist = end;
      } else if (end == N) {
        this.dist = N - 1 - start;
      } else {
        // 这是distance只能用 (end - start) / 2
        // 如果是(4, 9) sit 中间，其实距离得是2，所以跟(0, 4)之间坐属于同等distance
        this.dist = (end - start) / 2;
      }
    }
  }
}
