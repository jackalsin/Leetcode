package _001_100._030_Substring_With_Concatenation_of_All_Words;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/27.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void findSubstring() throws Exception {
    assertEquals(Arrays.asList(0, 9),
        solution.findSubstring("barfoothefoobarman", new String[] {"bar", "foo"}));
  }
  @Test
  public void findSubstringWithDup() throws Exception {
    assertEquals(Arrays.asList(8),
        solution.findSubstring("wordgoodgoodgoodbestword",
            new String[] {"word","good","best","good"}));
  }
}