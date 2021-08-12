package _0001_0050._016_3Sum_Closest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/21.
 */
public class SolutionTest {

  private static final int[] ARRAY_1 = new int[]{-1, 2, 1, -4};
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testArray1() throws Exception {
    assertEquals(2, solution.threeSumClosest(ARRAY_1, 1));
  }

}