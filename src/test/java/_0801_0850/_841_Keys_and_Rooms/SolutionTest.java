package _0801_0850._841_Keys_and_Rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> input = List.of(
        List.of(1), List.of(2), List.of(3), List.of()
    );
    assertTrue(solution.canVisitAllRooms(input));
  }

  @Test
  void testOnlineCase2() {
    final List<List<Integer>> input = List.of(
        List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)
    );
    assertFalse(solution.canVisitAllRooms(input));
  }
}