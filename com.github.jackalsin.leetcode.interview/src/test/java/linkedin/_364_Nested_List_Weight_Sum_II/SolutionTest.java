package linkedin._364_Nested_List_Weight_Sum_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.nestedInteger.NestedInteger;
import utils.nestedInteger.NestedIntegerImpl;

import java.util.List;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final List<NestedInteger> input = List.of(new NestedIntegerImpl(new NestedIntegerImpl(1),
        new NestedIntegerImpl(1)), new NestedIntegerImpl(2), new NestedIntegerImpl(new
        NestedIntegerImpl(1), new NestedIntegerImpl(1)));

    assertEquals(8, solution.depthSumInverse(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<NestedInteger> input = of(new NestedIntegerImpl(1), new NestedIntegerImpl(
        new NestedIntegerImpl(4), new NestedIntegerImpl(new NestedIntegerImpl(6))
    ));
    assertEquals(17, solution.depthSumInverse(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI(),
        new SolutionVII()
    );
  }

}