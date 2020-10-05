package pinterest._269_Alien_Dictionary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testExample1() {
    assertEquals("wertf", solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
  }

  @Test
  void testExample2() {
    assertEquals("zx", solution.alienOrder(new String[]{"z", "x"}));
  }

  @Test
  void testExample3() {
    assertEquals("", solution.alienOrder(new String[]{"z", "x", "z"}));
  }

  @Test
  void testFailed() {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @Test
  void testFailed2() {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @Test
  void testFailed3() {
    // z -> c, a -> b
    Set<String> expected = Set.of("abzc", "azbc", "azcb", "zcab", "zacb", "zabc");
    final String actual = solution.alienOrder(new String[]{"za", "zb", "ca", "cb"});
    assertTrue(expected.contains(actual));
  }
}