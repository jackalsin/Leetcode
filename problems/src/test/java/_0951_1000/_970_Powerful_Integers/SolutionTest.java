package _0951_1000._970_Powerful_Integers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<Integer> actual = solution.powerfulIntegers(2, 3, 10);
    assertEquals(Set.of(
        2, 3, 4, 5, 7, 9, 10
    ), new HashSet<>(actual));
  }

  @Test
  void testOnlineCase2() {
    final List<Integer> actual = solution.powerfulIntegers(3, 5, 15);
    assertEquals(Set.of(
        2, 4, 6, 8, 10, 14
    ), new HashSet<>(actual));
  }

  @Test
  void testTLE1() {
    final List<Integer> actual = solution.powerfulIntegers(1, 2, 100);
    assertEquals(Set.of(
        33, 2, 3, 5, 65, 9, 17), new HashSet<>(actual));
  }
}