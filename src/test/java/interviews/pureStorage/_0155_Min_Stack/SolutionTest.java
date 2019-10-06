package interviews.pureStorage._0155_Min_Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(MinStack minStack) {
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin());  //  --> Returns -3.
    minStack.pop();
    assertEquals(0, minStack.top());
    assertEquals(-2, minStack.getMin());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(MinStack minStack) {
    minStack.push(0);
    minStack.push(1);
    minStack.push(0);
    assertEquals(0, minStack.getMin());  //  --> Returns 0.
    minStack.pop();
    assertEquals(0, minStack.getMin());
  }

  static Stream<MinStack> solutionProvider() {
    return Stream.of(
        new TwoStackSolution(),
        new OneStackSolution()
    );
  }
}