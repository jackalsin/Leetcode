package _051_100._087_Scramble_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/28/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp()  {
    solution = new Solution();
  }

  @Test
  public  void testOnlineCase() throws Exception {
    assertTrue(solution.isScramble("rgtae", "great"));
  }

  @Test
  public void testABC() throws Exception {
    assertTrue(solution.isScramble("abc", "bca"));
  }

  @Test
  public void testTLECase() throws Exception {
    assertFalse(solution.isScramble("abcdefghijklmnopq" ,"efghijklmnopqcadb"));
  }
}
