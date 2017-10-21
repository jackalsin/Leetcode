package interviews.linkedin._149_Max_Points_on_a_Line;

import org.junit.Before;
import org.junit.Test;

import utils.Point;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFailedCountSelf() throws Exception {
    final Point[] points = {new Point(0, 0)};
    assertEquals(1, solution.maxPoints(points));
  }

  @Test
  public void testEmpty() throws Exception {
    final Point[] points = {};
    assertEquals(0, solution.maxPoints(points));
  }

  @Test
  public void testFailedCase() throws Exception {
    final Point[] points = {new Point(0, 0), new Point(1, 1), new Point(0, 0),};
    assertEquals(3, solution.maxPoints(points));
  }
}
