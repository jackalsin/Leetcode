package _051_100._069_Sqrt_x;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/27/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertEquals(1, solution.mySqrt(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(1, solution.mySqrt(2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(1, solution.mySqrt(3));
  }
  @Test
  public void test4() throws Exception {
    assertEquals(2, solution.mySqrt(4));
  }
  @Test
  public void test5() throws Exception {
    assertEquals(2, solution.mySqrt(5));
  }
  @Test
  public void test2147395599() throws Exception {
    assertEquals(46339, solution.mySqrt(2147395599));
  }
}