package airbnb.menuCombinationSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceSolutionITest {
  private static final double DELTA = 1E-3;
  private PriceSolution solution;

  @BeforeEach
  void setUp() {
    solution = new PriceSolutionI();
  }

  @Test
  void testOnlineCase1() {
    final List<Double> input = List.of(1d, 2d);
    final List<List<Double>> expected = List.of(
        List.of(1d, 1d, 1d),
        List.of(1d, 2d)
    ), actual = solution.combinationSum(input, 3d, DELTA);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testOnlineCaseSingle0() {
    final List<Double> input = List.of(0d, 1d, 2d);
    final List<List<Double>> expected = List.of(
        List.of(1d, 1d, 1d),
        List.of(1d, 2d),
        List.of(0d, 1d, 1d, 1d),
        List.of(0d, 1d, 2d)
    ), actual = solution.combinationSum(input, 3d, DELTA);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testOnlineCaseMultiple0() {
    final List<Double> input = List.of(
        0d, 0d, 1d, 2d
    );
    final List<List<Double>> expected = List.of(
        List.of(1d, 1d, 1d),
        List.of(1d, 2d),
        List.of(0d, 1d, 1d, 1d),
        List.of(0d, 1d, 2d),
        List.of(0d, 0d, 1d, 2d),
        List.of(0d, 0d, 1d, 1d, 1d)
    ), actual = solution.combinationSum(input, 3d, DELTA);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }
}