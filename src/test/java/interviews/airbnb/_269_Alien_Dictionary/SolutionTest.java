package interviews.airbnb._269_Alien_Dictionary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/31/2019.
 */
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
    final Set<String> expected = Set.of("acb", "cab");
    final String actual = solution.alienOrder(new String[]{"ac", "ab", "b"});
    assertTrue(expected.contains(actual));
  }

  @Test
  void testFailed2() {
    // ab, zc,
    final Set<String> expected = Set.of("abzc", "azcb", "azbc");
    final String actual = solution.alienOrder(new String[]{"za", "zb", "ca", "cb"});
    assertTrue(expected.contains(actual));
  }

  /**
   * 自环还是valid，其他是invalid
   *
   * @throws Exception
   */
  @Test
  void testFailed3() {
    assertEquals("z", solution.alienOrder(new String[]{"z", "z"}));
  }
}