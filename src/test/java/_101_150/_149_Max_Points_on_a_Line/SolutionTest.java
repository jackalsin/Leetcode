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

  @Test
  public void testNormalMax() throws Exception {
    final Point[] input = new Point[] {new Point(1, 1), new Point(2,2), new Point(3, 3),
        new Point(-1, 1)};
    assertEquals(3, solution.maxPoints(input));
  }

  @Test
  public void testAbnormalMax() throws Exception {
    final Point[] input = new Point[] {new Point(1, 1), new Point(1,2), new Point(1, 3),
        new Point(-1, 1)};
    assertEquals(3, solution.maxPoints(input));
  }

  @Test
  public void testFailedCase() throws Exception {
    final Point[] points = new Point[] {new Point(0, 0), new Point(1, 1), new Point(1, -1)};
    assertEquals(2, solution.maxPoints(points));
  }

  @Test
  public void testFailedCase2OnDup() throws Exception {
    final Point[] points = new Point[] {new Point(0, 0), new Point(1, 1), new Point(0, 0)};
    assertEquals(3, solution.maxPoints(points));
  }

  @Test
  public void testDupOnly() throws Exception {
    final Point[] points = new Point[] {new Point(0, 0), new Point(0, 0)};
    assertEquals(2, solution.maxPoints(points));
  }

  @Test
  public void testFailed3() throws Exception {
    final Point[] points = new Point[] {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
    assertEquals(3, solution.maxPoints(points));
  }

  @Test
  public void testFailed4() throws Exception {
    final Point[] points = new Point[] {
        new Point(3, 1), new Point(12, 3), new Point(3, 1), new Point(-6, -1)
    };
    assertEquals(4, solution.maxPoints(points));
  }

  @Test
  public void testFailed5() throws Exception {
    final Point[] points = new Point[] {
        new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)
    };
    assertEquals(2, solution.maxPoints(points));
  }

}
