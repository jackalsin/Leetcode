package _051_100._095_Unique_Binary_Search_Trees_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 6/6/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZero() throws Exception {
    assertEquals(new ArrayList<>(), solution.generateTrees(0));
  }

}