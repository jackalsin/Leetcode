package example.overrideEquals.violateLiskovSubstitutionPrinciple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author jacka
 * @version 1.0 on 6/29/2019
 */
class PointTest {

  @Test
  void testLiskovSubstitutionPrinciple() {
    final CounterPoint cp = new CounterPoint(0, 1);
    // Broken - violate Liskov substitution principle
    assertFalse(Point.onUnitCircle(cp));
  }

}