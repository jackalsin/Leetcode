package _1151_1200._1172_Dinner_Plate_Stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<DinnerPlates> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    DinnerPlates solution = solutionClass.getConstructor(Integer.TYPE).newInstance(2);
    solution.push(1);
    solution.push(2);
    solution.push(3);
    solution.push(4);
    solution.push(5);
    assertEquals(2, solution.popAtStack(0));
    solution.push(20);
    solution.push(21);
    assertEquals(20, solution.popAtStack(0));
    assertEquals(21, solution.popAtStack(2));
    assertEquals(5, solution.pop());
    assertEquals(4, solution.pop());
    assertEquals(3, solution.pop());
    assertEquals(1, solution.pop());
    assertEquals(-1, solution.pop());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SolutionI.class
    );
  }
}