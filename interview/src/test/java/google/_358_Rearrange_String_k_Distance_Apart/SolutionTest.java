package google._358_Rearrange_String_k_Distance_Apart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    assertEquals("abcabc", solution.rearrangeString("aabbcc", 3));
  }

  @Test
  void testOnlineCase2() throws Exception {
    assertEquals("", solution.rearrangeString("aaabc", 3));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String actual = solution.rearrangeString("aaadbbcc", 2);
    assertTrue(Set.of("abacabcd", "abcabcda").contains(actual));
  }

}
