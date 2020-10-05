package linkedin._170_Two_Sum_III_Data_structure_design;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public interface TwoSum {

  /**
   * Add the number to an internal data structure..
   */
  void add(int number);

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   */
  boolean find(int value);

}
