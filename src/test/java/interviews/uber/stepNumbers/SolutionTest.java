package interviews.uber.stepNumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private static final Set<Integer> NO_GREATER_THAN_100 = Set.of(
      1, 2, 3, 4, 5, 6, 7, 8, 9,
      10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 90, 98
  );
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase100() {
    final Set<Integer> actual = solution.generateNoGreaterThan(100);
    assertEquals(NO_GREATER_THAN_100, actual);
  }

  @Test
  void testOnlineCase7() {
    final Set<Integer> actual = solution.generateNoGreaterThan(7),
        expected = Set.of(1, 2, 3, 4, 5, 6, 7);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase35() {
    final Set<Integer> actual = solution.generateNoGreaterThan(35),
        expected = Set.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 12, 21, 23, 32, 34
        );
    assertEquals(expected, actual);
  }
}