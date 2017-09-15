package utils.segementTree;

/**
 * @author jacka
 * @version 1.0 on 9/14/2017.
 */
public interface SegementTree {

  /**
   * Update the value to <tt>val</tt> on index <tt>i</tt>.
   * @param i index to update
   * @param val value to set
   */
  void update(int i, int val);

  /**
   * To get the result of the range.
   *
   * @param rangeStart  range left boundary, inclusive
   * @param rangeEnd    range right boundary, inclusive
   * @return  result of the range, like sum, minimum value.
   */
  int get(int rangeStart, int rangeEnd);

}
