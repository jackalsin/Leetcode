package _0201_0250._201_Bitwise_AND_of_Numbers_Range;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/2/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZero() throws Exception {
    assertEquals(0, solution.rangeBitwiseAnd(0, 0));
  }

  @Test
  public void test1And2() throws Exception {
    assertEquals(0, solution.rangeBitwiseAnd(1, 2));
  }
  @Test
  public void test0b101010And0b101101() throws Exception {
    assertEquals(0b101000, solution.rangeBitwiseAnd(0b101101,
                                                      0b101010));
  }
}

