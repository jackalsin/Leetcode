package _101_150._149_Max_Points_on_a_Line;

import org.junit.Before;
import org.junit.Test;

import utils.Point;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/10/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final Point[] input = new Point[] {};
    assertEquals(0, solution.maxPoints(input));
  }

  @Test
  public void test1() throws Exception {
    final Point[] input = new Point[] {new Point(1, 1)};
    assertEquals(1, solution.maxPoints(input));
  }

  @Test
  public void test2() throws Exception {
    final Point[] input = new Point[] {new Point(1, 1), new Point(2,2)};
    assertEquals(2, solution.maxPoints(input));
  }
}
