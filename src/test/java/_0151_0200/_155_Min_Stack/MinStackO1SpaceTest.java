package _0151_0200._155_Min_Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackO1SpaceTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Class<MinStack> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final MinStack minStack = solutionClass.getConstructor().newInstance();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin());  //  --> Returns -3.
    minStack.pop();
    assertEquals(0, minStack.top());
    assertEquals(-2, minStack.getMin());
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        MinStackO1Space.class
    );
  }
}