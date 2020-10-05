package linkedin._715_Range_Module;

/**
 * TODO: Revisit
 *
 * @author jacka
 * @version 1.0 on 7/27/2019
 */
public interface Solution {
  void addRange(int left, int right);

  /**
   * Returns true if and only if every real number in the interval [left, right) is currently being tracked.
   *
   * @param left
   * @param right
   * @return
   */
  boolean queryRange(int left, int right);

  void removeRange(int left, int right);
}
