package _0151_0200._190_Reverse_Bits;

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
  public void test1() throws Exception {
    assertEquals(1<<31, solution.reverseBits(1));
  }

  @Test
  public void test() throws Exception {
    assertEquals(1<<30, solution.reverseBits(2));
  }

  @Test
  public void test2147483648() throws Exception {
    assertEquals(1, solution.reverseBits(0x80000000));
  }
}
