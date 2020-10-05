package airbnb.preferenceList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> input = List.of(
        List.of(3, 5, 7, 9), List.of(2, 3, 8), List.of(5, 8)
    );
    final List<Integer> expected = List.of(2, 3, 5, 7, 8, 9);

    assertEquals(expected, solution.getPreference(input));
  }
}