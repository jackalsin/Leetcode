package uber._254_Factor_Combinations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test1() {
    assertEquals(new ArrayList<>(), solution.getFactors(1));
  }

  @Test
  void test37() {
    assertEquals(new ArrayList<>(), solution.getFactors(37));
  }

  @Test
  void test12() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 2, 3));
    expected.add(Arrays.asList(2, 6));
    expected.add(Arrays.asList(3, 4));
    List<List<Integer>> actual = solution.getFactors(12);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void test32() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 16));
    expected.add(Arrays.asList(2, 2, 8));
    expected.add(Arrays.asList(2, 2, 2, 4));
    expected.add(Arrays.asList(2, 2, 2, 2, 2));
    expected.add(Arrays.asList(2, 4, 4));
    expected.add(Arrays.asList(4, 8));
    List<List<Integer>> actual = solution.getFactors(32);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}