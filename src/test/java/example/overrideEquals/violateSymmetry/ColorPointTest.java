package example.overrideEquals.violateSymmetry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 6/29/2019
 */
class ColorPointTest {

  @Test
  void testReflexivity() {
    final Point point = new ColorPoint(1, 1, Color.RED);
    final ColorPoint colorPoint = new ColorPoint(1, 1, Color.RED);
    assertTrue(point.equals(point));
    assertTrue(colorPoint.equals(colorPoint));
    assertTrue(point.equals(colorPoint));
    assertTrue(colorPoint.equals(point));
  }

  @Test
  void testSymmetry() {
    Point p = new Point(1, 1);
    ColorPoint cp = new ColorPoint(1, 1, Color.RED);
    assertFalse(cp.equals(p)); // should be true
    assertTrue(p.equals(cp));
  }
}