package facebook._307_Range_Sum_Query_Mutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumArrayTest {
  private NumArray solution;

  @Test
  void testOnlineCase1() {
    final int[] input = {1, 3, 5};
    solution = new NumArray(input);
    assertEquals(9, solution.sumRange(0, 2));
    solution.update(1, 2);
    assertEquals(8, solution.sumRange(0, 2));
  }
}