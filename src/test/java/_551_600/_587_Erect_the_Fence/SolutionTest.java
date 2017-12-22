package _551_600._587_Erect_the_Fence;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Point;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
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
    final Point[] input = {
        new Point(1, 1),
        new Point(2, 2),
        new Point(2, 0),
        new Point(2, 4),
        new Point(3, 3),
        new Point(4, 2)
    };
    final Set<Point> output = Set.of(
        new Point(1, 1),
        new Point(2, 0),
        new Point(4, 2),
        new Point(3, 3),
        new Point(2, 4)
    );
    final List<Point> actual = solution.outerTrees(input);

    assertEquals(output, new HashSet<>(actual));
  }

  /**
   *
   * @throws Exception
   */
  @Test
  public void testOnlineCase2() throws Exception {
    final Point[] input = {
        new Point(1, 2),
        new Point(2, 2),
        new Point(4, 2)
    };
    final Set<Point> output = Set.of(
        new Point(1, 2),
        new Point(2, 2),
        new Point(4, 2)
    );
    final List<Point> actual = solution.outerTrees(input);

    assertEquals(output, new HashSet<>(actual));
  }
}
