package _0301_0350._313_Super_Ugly_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void  testOnlineCase() throws Exception {
    final int[] input = {2, 7, 13, 19};
//    final int[] input = {1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32};

    assertEquals(32, solution.nthSuperUglyNumber(12, input));
  }

}
