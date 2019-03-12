package interviews.airbnb.simulateDiplomacy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    // 军队名 地点 1 action (地点 2／军队名)
    final List<String> input = List.of(
        "A place_A hold",
        "B place_B hold",
        "C place_C hold",
        "A place_A move place_B",
        "C place_C move place_B"
    );

    final Map<String, String> expected = Map.of(
        "A", "Dead",
        "B", "Dead",
        "C", "Dead"
    ), actual = solution.battle(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCaseWithSupport() {
    // 军队名 地点 1 action (地点 2／军队名)
    final List<String> input = List.of(
        "A place_A hold",
        "B place_B hold",
        "C place_C hold",
        "A place_A support B",
        "C place_C move place_B"
    );

    final Map<String, String> expected = Map.of(
        "A", "place_A",
        "B", "place_B",
        "C", "Dead"
    ), actual = solution.battle(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCaseWithSupportAttacked() {
    // 军队名 地点 1 action (地点 2／军队名)
    final List<String> input = List.of(
        "A place_A hold",
        "B place_B hold",
        "C place_C hold",
        "D place_D hold",
        "A place_A support B",
        "C place_C move place_B",
        "D place_D move place_A"
    );

    final Map<String, String> expected = Map.of(
        "A", "Dead",
        "B", "Dead",
        "C", "Dead",
        "D", "Dead"
    ), actual = solution.battle(input);
    assertEquals(expected, actual);
  }
}