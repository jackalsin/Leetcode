package interviews.airbnb.preferenceList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderGuaranteedSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new OrderGuaranteedSolution();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> input = List.of(
        List.of(3, 5, 7, 9), List.of(2, 3, 8), List.of(5, 8)
    );
    final List<Integer> expected = List.of(2, 3, 5, 7, 9, 8);
    assertEquals(expected, solution.getPreference(input));
  }

  @Test
  void testEmpty() {
    final List<List<Integer>> input = List.of();
    final List<Integer> expected = List.of();
    assertEquals(expected, solution.getPreference(input));
  }

  @Test
  void testOrder() {
    final List<List<Integer>> input = List.of(
        List.of(1, 5, 7), List.of(2, 3, 5), List.of(3, 5), List.of(4, 5)
    );
    final List<Integer> expected = List.of(1, 2, 3, 4, 5, 7);
    assertEquals(expected, solution.getPreference(input));
  }

  @Test
  void testOrder2() {
    final List<List<Integer>> input = List.of(
        List.of(4, 5, 7), List.of(3, 5), List.of(2, 5), List.of(1, 5)
    );
    final List<Integer> expected = List.of(4, 3, 2, 1, 5, 7);
    assertEquals(expected, solution.getPreference(input));
  }

}