package interviews.airbnb.travelBuddy;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/1/2019.
 */
public interface Solution {
  /**
   * Return a list of travel buddies
   * Travel buddies defined as follows:
   * 1. similarity >= 50%
   * <p>
   * The list is in the descending order of score
   *
   * @return
   */
  List<String> getTravelBuddies();

  List<String> getRecommendList(final int size);

}
