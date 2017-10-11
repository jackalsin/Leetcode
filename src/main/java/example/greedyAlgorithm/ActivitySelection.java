package example.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: You are given n activities with their start and finish times. Select the maximum
 * number of activities that can be performed by a single person, assuming that a person can only
 * work on a single activity at a time.
 *
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public final class ActivitySelection {

  /**
   *
   * @param activities
   */
  public List<Activity> maxSelection(final Activity[] activities) {
    List<Activity> result = new ArrayList<>();
    if (activities.length == 0) {
      return result;
    }
    Arrays.sort(activities, new Comparator<Activity>() {
      @Override
      public int compare(Activity o1, Activity o2) {
        if (o1.end == o2.end) {
          return Integer.compare(o1.start, o2.start);
        } else {
          return Integer.compare(o1.end, o2.end);
        }
      }
    });

    result.add(activities[0]);
    for (int i = 1; i < activities.length; ++i) {
      if (activities[i].start >= result.get(result.size() - 1).end) {
        result.add(activities[i]);
      }
    }

    return result;
  }

}
