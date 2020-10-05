package google.geo;

import definition.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/24/2018.
 */
public class SegmentCrossTest {
  private SegmentCross solution;

  @Before
  public void setUp() throws Exception {
    solution = new SegmentCross();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertFalse(solution.isCross(new Point(0, 0), new Point(1, 1), new Point(2, 2), new
        Point(3, 3)));
  }

  @Test
  public void testOnlineCase4() throws Exception {
    assertTrue(solution.isCross(new Point(0, 0), new Point(3, 3), new Point(1, 1), new
        Point(2, 2)));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertTrue(solution.isCross(new Point(1, 1), new Point(4, 4), new Point(1, 4), new
        Point(4, 1)));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    assertTrue(solution.isCross(new Point(1, 1), new Point(4, 4), new Point(1, 2), new
        Point(1, 3)));
  }
}
