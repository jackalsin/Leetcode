package interviews.airbnb.numberOfIntersectedRectangles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][][] rects = new int[][][]{
        {{0, 0}, {3, 3}},
        {{1, 1}, {4, 4}},
        {{5, 5}, {6, 6}}
    };

    assertEquals(2, solution.countIntersection(rects));
  }

  @Test
  void testOnlineCase2() {
    final int[][][] rects = new int[][][]{
        {{0, 0}, {3, 3}},
        {{1, 1}, {4, 4}},
        {{2, 2}, {6, 6}}
    };

    assertEquals(1, solution.countIntersection(rects));
  }
}