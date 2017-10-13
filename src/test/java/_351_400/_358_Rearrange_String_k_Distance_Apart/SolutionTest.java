package _351_400._358_Rearrange_String_k_Distance_Apart;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/12/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    assertEquals("abcabc", solution.rearrangeString("aabbcc", 3));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals("", solution.rearrangeString("aaabc", 3));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String actual = solution.rearrangeString("aaadbbcc", 2);
    assertTrue(Set.of("abacabcd", "abcabcda").contains(actual));
  }

}
