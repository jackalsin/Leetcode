package _0301_0350._303_Range_Sum_Query_Immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/12/2017.
 */
public class NumArrayTest {
  private NumArray numArray;

  @BeforeEach
  public void setUp() throws Exception {

  }

  @Test
  public void testOnline() throws Exception {
    final int[] input = {-2, 0, 3, -5, 2, -1};
    numArray = new NumArray(input);
    assertEquals(1, numArray.sumRange(0, 2));
    assertEquals(-1, numArray.sumRange(2, 5));
    assertEquals(-3, numArray.sumRange(0, 5));
  }

  @Test
  public void testEmpty() throws Exception {
    numArray = new NumArray(new int[]{});
  }
}
