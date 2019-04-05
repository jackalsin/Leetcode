package interviews.airbnb.testJustification;

import java.util.List;

public interface Solution {
  /**
   * Format based on the longest length
   *
   * @param strs
   * @return
   */
  List<String> format(final List<String> strs);

  /**
   * Format based on the <tt>width</tt>
   *
   * @param strs
   * @param width
   * @return
   */
  List<String> format(List<String> strs, final int width);

}
