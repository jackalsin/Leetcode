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
    solution = new SolutionII();
  }

  @Test
  public void testFailedCountSelf() {
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

  @Test
  public void testFailedCase2() throws Exception {
    //Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    final Point[] points = {new Point(1, 1), new Point(3, 2),
        new Point(5, 3), new Point(4, 1), new Point(2, 3), new Point(1, 4)};
    assertEquals(4, solution.maxPoints(points));
  }
}
