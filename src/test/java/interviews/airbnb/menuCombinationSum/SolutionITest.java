package interviews.airbnb.menuCombinationSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
class SolutionITest {
  private static final String BURGER = "Burger", CHIPS = "Chips",
      FRIES = "Fries", FRUIT = "Fruit";

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final Map<String, Long> candidates = Map.of(
        BURGER, 585L,
        CHIPS, 300L,
        FRIES, 305L,
        FRUIT, 315L
    );
    final List<List<String>> expected = List.of(
        List.of(BURGER, CHIPS)
    ), actual = solution.combinationSum(candidates, 885);
    System.out.println(actual);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}