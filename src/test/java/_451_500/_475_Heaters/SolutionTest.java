package _451_500._475_Heaters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/28/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] houses = {1, 2, 3}, heaters = {2};
    assertEquals(1, solution.findRadius(houses, heaters));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] houses = {1, 2, 3, 4}, heaters = {1, 4};
    assertEquals(1, solution.findRadius(houses, heaters));
  }

  @Test
  public void testOddIntervals() throws Exception {
    final int[] houses = {1, 2, 3, 4, 5, 6, 7, 8}, heaters = {2, 6};
    assertEquals(2, solution.findRadius(houses, heaters));
  }

  @Test
  public void testEvenIntervals() throws Exception {
    final int[] houses = {1, 2, 3, 4, 5, 6, 7, 8}, heaters = {2, 7};
    assertEquals(2, solution.findRadius(houses, heaters));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] houses = {1}, heaters = {1, 2, 3, 4};
    assertEquals(0, solution.findRadius(houses, heaters));
  }

}
