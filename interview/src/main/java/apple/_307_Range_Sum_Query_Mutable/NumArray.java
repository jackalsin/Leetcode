package apple._307_Range_Sum_Query_Mutable;

/**
 * @author jacka
 * @version 1.0 on 3/3/2021
 */
public interface NumArray {
  void update(int index, int val);

  int sumRange(int left, int right);
}
