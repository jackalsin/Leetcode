package definition;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class to provide several tools to create or control structure of notes.
 *
 * @author jacka
 * @version 1.0 on 2017/1/7.
 */
public final class Util {

  /**
   * Avoid initialization.
   */
  private Util() {
  }

  /**
   * Return a list contains all Intervals in {@param array}
   * @param array {{i1_start, i1_end},{i2_start, i2_end},{i3_start, i3_end},{i4_start, i4_end} }
   * @return
   */
  public static List<Interval> getIntervals(int[][] array) {
    List<Interval> result = new ArrayList<>();
    for (int[] child: array) {
      result.add(new Interval(child[0], child[1]));
    }
    return result;
  }
}
