package airbnb.maxNightsCanAccommodate;

public interface Solution {
  /**
   * // [5, 1, 1, 5] => 10
   * The above array would represent an example booking period as follows -
   * // Dec 1 – 5
   * // Dec 5 – 6
   * // Dec 6 – 7
   * // Dec 7 - 12
   * <p>
   * The constrain you have is that you must reserve 1 night between 2 books
   *
   * @param nums
   * @return
   */
  int maxNightsCanAccommodate(final int[] nums);
}
