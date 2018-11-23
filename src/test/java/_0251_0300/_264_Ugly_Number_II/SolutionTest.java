package _0251_0300._264_Ugly_Number_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertEquals(1, solution.nthUglyNumber(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(2, solution.nthUglyNumber(2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(3, solution.nthUglyNumber(3));
  }

  @Test
  public void test4() throws Exception {
    assertEquals(4, solution.nthUglyNumber(4));
  }

  @Test
  public void test5() throws Exception {
    assertEquals(5, solution.nthUglyNumber(5));
  }

  @Test
  public void test6() throws Exception {
    assertEquals(6, solution.nthUglyNumber(6));
  }

  @Test
  public void test7() throws Exception {
    assertEquals(8, solution.nthUglyNumber(7));
  }

  @Test
  public void test8() throws Exception {
    assertEquals(9, solution.nthUglyNumber(8));
  }

  @Test
  public void test9() throws Exception {
    assertEquals(10, solution.nthUglyNumber(9));
  }

  @Test
  public void test10() throws Exception {
    assertEquals(12, solution.nthUglyNumber(10));
  }

  @Test
  public void test11() throws Exception {
    assertEquals(15, solution.nthUglyNumber(11));
  }

}
