package _451_500._484_Find_Permutation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new NaiveSolution();
    solution = new EasyUnderstandSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String s = "DDIIDI";
    final int[] expected = {3, 2, 1, 4, 6, 5, 7};
    assertArrayEquals(expected, solution.findPermutation(s));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String s = "I";
    final int[] expected = {1, 2};
    assertArrayEquals(expected, solution.findPermutation(s));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String s = "DI";
    final int[] expected = {2, 1, 3};
    assertArrayEquals(expected, solution.findPermutation(s));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String s = "D";
    final int[] expected = {2, 1};
    assertArrayEquals(expected, solution.findPermutation(s));
  }

}