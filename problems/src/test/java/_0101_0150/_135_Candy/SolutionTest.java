package _0101_0150._135_Candy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.candy(new int[]{}));
  }

  @Test
  public void testOne() throws Exception {
    assertEquals(1, solution.candy(new int[]{1}));
  }

  @Test
  public void testOneZero() throws Exception {
    assertEquals(1, solution.candy(new int[]{0}));
  }

  @Test
  public void testNonZero() throws Exception {
    final int[] ratings = new int[]{4, 3, 2, 1, 4};
    assertEquals(12, solution.candy(ratings));
  }

  @Test
  public void testWithZero() throws Exception {
    final int[] ratings = new int[]{4, 3, 2, 1, 0, 4};
    assertEquals(17, solution.candy(ratings));
  }

  @Test
  public void testWith122() throws Exception {
    final int[] ratings = new int[]{1, 2, 2};
    assertEquals(4, solution.candy(ratings));
  }

  @Test
  public void testWith22() throws Exception {
    final int[] ratings = new int[]{2, 2};
    assertEquals(2, solution.candy(ratings));
  }
}
