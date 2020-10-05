package linkedin.mianjing._149_Max_Points_on_a_Line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testEmpty() {
    final Point[] input = new Point[]{};
    assertEquals(0, solution.maxPoints(input));
  }

  @Test
  void test1() {
    final Point[] input = new Point[]{new Point(1, 1)};
    assertEquals(1, solution.maxPoints(input));
  }

  @Test
  void test2() {
    final Point[] input = new Point[]{new Point(1, 1), new Point(2, 2)};
    assertEquals(2, solution.maxPoints(input));
  }

  @Test
  void testNormalMax() {
    final Point[] input = new Point[]{new Point(1, 1), new Point(2, 2), new Point(3, 3),
        new Point(-1, 1)};
    assertEquals(3, solution.maxPoints(input));
  }

  @Test
  void testAbnormalMax() {
    final Point[] input = new Point[]{new Point(1, 1), new Point(1, 2), new Point(1, 3),
        new Point(-1, 1)};
    assertEquals(3, solution.maxPoints(input));
  }

  @Test
  void testFailedCase() {
    final Point[] points = new Point[]{new Point(0, 0), new Point(1, 1), new Point(1, -1)};
    assertEquals(2, solution.maxPoints(points));
  }

  @Test
  void testFailedCase2OnDup() {
    final Point[] points = new Point[]{new Point(0, 0), new Point(1, 1), new Point(0, 0)};
    assertEquals(3, solution.maxPoints(points));
  }

  @Test
  void testDupOnly() {
    final Point[] points = new Point[]{new Point(0, 0), new Point(0, 0)};
    assertEquals(2, solution.maxPoints(points));
  }

  @Test
  void testFailed3() {
    final Point[] points = new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
    assertEquals(3, solution.maxPoints(points));
  }

  @Test
  void testFailed4() {
    final Point[] points = new Point[]{
        new Point(3, 1), new Point(12, 3), new Point(3, 1), new Point(-6, -1)
    };
    assertEquals(4, solution.maxPoints(points));
  }

  @Test
  void testFailed5() {
    final Point[] points = new Point[]{
        new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)
    };
    assertEquals(2, solution.maxPoints(points));
  }


  @Test
  void testGcd12And24() {
    assertEquals(12, SolutionI.gcd(12, 24));
  }

  @Test
  void testGcd84And96() {
    assertEquals(12, SolutionI.gcd(12 * 7, 12 * 6));
  }

}