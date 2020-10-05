package linkedin.mianjing._364_Nested_List_Weight_Sum_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.nestedInteger.NestedInteger;
import utils.nestedInteger.NestedIntegerImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final List<NestedInteger> input = List.of(new NestedIntegerImpl(new NestedIntegerImpl(1),
        new NestedIntegerImpl(1)), new NestedIntegerImpl(2), new NestedIntegerImpl(new
        NestedIntegerImpl(1), new NestedIntegerImpl(1)));

    assertEquals(8, solution.depthSumInverse(input));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final List<NestedInteger> input = List.of(new NestedIntegerImpl(1), new NestedIntegerImpl(
        new NestedIntegerImpl(4), new NestedIntegerImpl(new NestedIntegerImpl(6))
    ));
    assertEquals(17, solution.depthSumInverse(input));
  }


}