package _051_100._060_Permutation_Sequence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/22/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith3And1() throws Exception {
    assertEquals("123", solution.getPermutation(3, 1));
  }

  @Test
  public void testWith3And2() throws Exception {
    assertEquals("132", solution.getPermutation(3, 2));
  }

  @Test
  public void testWith3And3() throws Exception {
    assertEquals("213", solution.getPermutation(3,3 ));
  }

  @Test
  public void testWith3And4() throws Exception {
    assertEquals("231", solution.getPermutation(3,4));
  }

}