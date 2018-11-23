package _0351_0400._394_Decode_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline1() throws Exception {
    assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
  }

  @Test
  public void testOnline2() throws Exception {
    assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
  }

  @Test
  public void testOnline3() throws Exception {
    assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
  }
}
