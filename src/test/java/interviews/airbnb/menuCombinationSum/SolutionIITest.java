package interviews.airbnb.menuCombinationSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {

  private static final String BURGER = "Burger", CHIPS = "Chips",
      FRIES = "Fries", FRUIT = "Fruit", FREE1 = "Free1", FREE2 = "Free2";
  private static final double DELTA = 1E-3;
  private MenuSolution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final Map<String, Double> candidates = Map.of(
        BURGER, 585d,
        CHIPS, 300d,
        FRIES, 305d,
        FRUIT, 315d
    );
    final List<List<String>> expected = List.of(
        List.of(BURGER, CHIPS)
    ), actual = solution.combinationSum(candidates, 885, DELTA);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testOnlineCaseSingle0() {
    final Map<String, Double> candidates = Map.of(
        FREE1, 0d,
        BURGER, 585d,
        CHIPS, 300d,
        FRIES, 305d,
        FRUIT, 315d
    );
    final List<List<String>> expected = List.of(
        List.of(BURGER, CHIPS),
        List.of(BURGER, CHIPS, FREE1)
    ), actual = solution.combinationSum(candidates, 885, DELTA);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testOnlineCaseMultiple0() {
    final Map<String, Double> candidates = Map.of(
        FREE1, 0d,
        FREE2, 0d,
        BURGER, 585d,
        CHIPS, 300d,
        FRIES, 305d,
        FRUIT, 315d
    );
    final List<List<String>> expected = List.of(
        List.of(BURGER, CHIPS),
        List.of(BURGER, CHIPS, FREE1),
        List.of(BURGER, CHIPS, FREE2),
        List.of(BURGER, CHIPS, FREE1, FREE2)
    ), actual = solution.combinationSum(candidates, 885, DELTA);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}
