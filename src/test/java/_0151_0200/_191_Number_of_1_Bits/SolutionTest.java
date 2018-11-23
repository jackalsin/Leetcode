package _0151_0200._191_Number_of_1_Bits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/26/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test11() throws Exception {
    assertEquals(3, solution.hammingWeight(11));
  }
}
