package _551_600._554_Brick_Wall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 2, 1),
        List.of(3, 1, 2),
        List.of(1, 3, 2),
        List.of(2, 4),
        List.of(3, 1, 2),
        List.of(1, 3, 1, 1)
    );

    assertEquals(2, solution.leastBricks(input));
  }

  @Test
  void testOnlineCase2() {
    final List<List<Integer>> input = List.of(
        List.of(1),
        List.of(1),
        List.of(1)
    );

    assertEquals(3, solution.leastBricks(input));
  }

}