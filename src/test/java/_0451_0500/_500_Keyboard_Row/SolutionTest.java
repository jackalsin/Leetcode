package _0451_0500._500_Keyboard_Row;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
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
    final String[] Input = {"Hello", "Alaska", "Dad", "Peace"};
    final Set<String> expected = Set.of("Alaska", "Dad");
    final String[] actual = solution.findWords(Input);
    assertEquals(expected, new HashSet<>(Arrays.asList(actual)));
  }
}