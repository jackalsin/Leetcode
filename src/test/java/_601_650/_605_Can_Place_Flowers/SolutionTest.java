package _601_650._605_Can_Place_Flowers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] followerBed = {1, 0, 0, 0, 1};
    assertTrue(solution.canPlaceFlowers(followerBed, 1));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] followerBed = {1, 0, 0, 0, 1};
    assertFalse(solution.canPlaceFlowers(followerBed, 2));
  }


  @Test
  public void testFailedCase1() throws Exception {
    final int[] followerBed = {1, 0, 0, 0, 0, 1};
    assertFalse(solution.canPlaceFlowers(followerBed, 2));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] followerBed = {};
    assertFalse(solution.canPlaceFlowers(followerBed, 1));
  }

  @Test
  public void testSinglePlot() throws Exception {
    final int[] followerBed = {0};
    assertTrue(solution.canPlaceFlowers(followerBed, 1));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] flowerBed = {0, 0, 0, 0, 0, 1, 0, 0};
    assertTrue(solution.canPlaceFlowers(flowerBed, 0));
  }
}
