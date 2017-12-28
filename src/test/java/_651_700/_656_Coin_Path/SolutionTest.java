package _651_700._656_Coin_Path;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] A = {1, 2, 4, -1, 2};
    final int B = 2;
    assertEquals(List.of(1, 3, 5), solution.cheapestJump(A, B));
  }

  @Test
  public void testFailedOnLexicographically() {
    final int[] A = {0, 0, 0, 0, 0, 0};
    final int B = 3;
    assertEquals(List.of(1, 2, 3, 4, 5, 6), solution.cheapestJump(A, B));
  }

  @Test
  public void testFailedCase2() throws Exception {
    // A[40] = 0;
    final int[] A = {21, 7, 96, 68, 73, 99, 19, 89, 0, 62, 86, 8, 6, 62, 49, 77, 47, 12, 86, 5,
        46, 29, 3, 41, 68, 50, 83, 41, 77, 29, 10, 91, 75, 23, 59, 36, 8, 26, 26, 88, -1, 41, 45,
        32, 3, 51, 83, 75, 12, 48, 99, 38, 21, 98, 83, 46, 42, 48, 64, 92, 70, 6, 96, 30, 65, 7,
        90, 95, 5, 97, 25, 7, 99, 2, 26, 42, 38, 95, 26, 11, 86, 24, 16, 87, 77, 58, 30, 31};
    final int B = 1;
    assertEquals(List.of(), solution.cheapestJump(A, B));
  }
}
