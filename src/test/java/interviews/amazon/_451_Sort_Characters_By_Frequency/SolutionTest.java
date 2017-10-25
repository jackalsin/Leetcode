package interviews.amazon._451_Sort_Characters_By_Frequency;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(Set.of("eert", "eetr").contains(solution.frequencySort("tree")));
  }

}
