package _351_400._364_Nested_List_Weight_Sum_II;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import utils.nestedInteger.NestedInteger;
import utils.nestedInteger.NestedIntegerImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/13/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final List<NestedInteger> input = List.of(new NestedIntegerImpl(new NestedIntegerImpl(1),
        new NestedIntegerImpl(1)), new NestedIntegerImpl(2), new NestedIntegerImpl(new
        NestedIntegerImpl(1), new NestedIntegerImpl(1)));

    assertEquals(8, solution.depthSumInverse(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final List<NestedInteger> input = List.of(new NestedIntegerImpl(1), new NestedIntegerImpl(
        new NestedIntegerImpl(4), new NestedIntegerImpl(new NestedIntegerImpl(6))
    ));
    assertEquals(17, solution.depthSumInverse(input));
  }


}
