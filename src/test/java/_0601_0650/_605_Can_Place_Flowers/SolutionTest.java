package _0601_0650._605_Can_Place_Flowers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final int[] followerBed = {1, 0, 0, 0, 1};
    assertTrue(solution.canPlaceFlowers(followerBed, 1));
  }

  @Test
  void testOnlineCase2() {
    final int[] followerBed = {1, 0, 0, 0, 1};
    assertFalse(solution.canPlaceFlowers(followerBed, 2));
  }


  @Test
  void testFailedCase1() {
    final int[] followerBed = {1, 0, 0, 0, 0, 1};
    assertFalse(solution.canPlaceFlowers(followerBed, 2));
  }

  @Test
  void testEmpty() {
    final int[] followerBed = {};
    assertFalse(solution.canPlaceFlowers(followerBed, 1));
  }

  @Test
  void testSinglePlot() {
    final int[] followerBed = {0};
    assertTrue(solution.canPlaceFlowers(followerBed, 1));
  }

  @Test
  void testFailedCase2() {
    final int[] flowerBed = {0, 0, 0, 0, 0, 1, 0, 0};
    assertTrue(solution.canPlaceFlowers(flowerBed, 0));
  }
}
