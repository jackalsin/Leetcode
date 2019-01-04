package interviews.uber._658_Find_K_Closest_Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int Input[] = {1, 2, 3, 4, 5}, k = 4, x = 3;
    final List<Integer> expected = List.of(1, 2, 3, 4);
    assertEquals(expected, solution.findClosestElements(Input, k, x));
  }

  @Test
  void testOnlineCase2() {
    final int Input[] = {1, 2, 3, 4, 5}, k = 4, x = -1;
    final List<Integer> expected = List.of(1, 2, 3, 4);
    assertEquals(expected, solution.findClosestElements(Input, k, x));
  }

}