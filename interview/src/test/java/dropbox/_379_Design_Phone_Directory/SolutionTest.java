package dropbox._379_Design_Phone_Directory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int NUM = 4;
    final Solution phoneDirectory = solutionClass.getConstructor(Integer.TYPE).newInstance(NUM);
    for (int i = 0; i < NUM; i++) {
      assertTrue(phoneDirectory.check(i));
    }

    for (int i = 0; i < NUM; i++) {
      final int get = phoneDirectory.get();
      assertFalse(phoneDirectory.check(get));
    }
    assertEquals(-1, phoneDirectory.get());
    for (int i = 0; i < NUM; i++) {
      phoneDirectory.release(i);
      assertTrue(phoneDirectory.check(i));
    }
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final Solution solution = solutionClass.getConstructor(Integer.TYPE).newInstance(1);
    assertTrue(solution.check(0));
    assertEquals(0, solution.get());
    assertFalse(solution.check(0));
    assertEquals(-1, solution.get());
    solution.release(0);
    assertTrue(solution.check(0));
    assertEquals(0, solution.get());
    assertEquals(-1, solution.get());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SetAndQueueSolution.class,
        SegmentTreeSolution.class,
        SetAndQueueSolutionI.class
    );
  }
}