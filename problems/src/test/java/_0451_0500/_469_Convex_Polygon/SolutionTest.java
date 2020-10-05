package _0451_0500._469_Convex_Polygon;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/22/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  /**
   *
   * @throws Exception
   */
  @Test
  public void testOnlineCase1() throws Exception {
    final List<List<Integer>> points = List.of(
        List.of(0, 0),
        List.of(0, 1),
        List.of(1, 1),
        List.of(1, 0)
    );
    assertTrue(solution.isConvex(points));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final List<List<Integer>> points = List.of(
        List.of(0, 0),
        List.of(0, 10),
        List.of(10, 10),
        List.of(10, 0),
        List.of(5, 5)
    );
    assertFalse(solution.isConvex(points));
  }

  @Test
  public void test3Points() throws Exception {
    final List<List<Integer>> points = List.of(
        List.of(0, 0),
        List.of(0, 10),
        List.of(10, 10)
    );
    assertTrue(solution.isConvex(points));
  }

  /**
   * Multiple points are on the same line.
   */
  @Test
  public void testFailedCase1() throws Exception {
    final List<List<Integer>> points = List.of(
        List.of(0, 0), // 0
        List.of(0, 1), // 1
        List.of(1, 1), // 2
        List.of(2, 1), // 3
        List.of(2, 2),
        List.of(2, 3),
        List.of(3, 3),
        List.of(3, 0)
    );

    assertFalse(solution.isConvex(points));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final List<List<Integer>> points = List.of(
        List.of(0, 1907), // 0
        List.of(6, 952), // 1
        List.of(12, 29), // 2
        List.of(376, 23), // 3
        List.of(1217, 10), // 4
        List.of(2622, 2),
        List.of(9260, 5),
        List.of(9729, 33),
        List.of(9977, 111),
        List.of(9995, 3692),
        List.of(9984, 8244),
        List.of(9963, 9092),
        List.of(9941, 9740),
        List.of(9915, 9966),
        List.of(9754, 9992),
        List.of(9665, 9999), //15 fails here
        List.of(808, 9997),
        List.of(201, 9966),
        List.of(93, 9928),
        List.of(4, 9247),
        List.of(2, 7152),
        List.of(0, 4926));
    assertTrue(solution.isConvex(points));
  }
}
