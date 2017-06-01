package _051_100._091_Decode_Ways;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/31/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZeroElement() throws Exception {
    assertEquals(0, solution.numDecodings(""));
  }


}