package _0351_0400._379_Design_Phone_Directory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneDirectoryTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<PhoneDirectory> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int NUM = 3;
    final PhoneDirectory phoneDirectory = solutionClass.getConstructor(Integer.TYPE).newInstance(NUM);
    for (int i = 0; i < NUM; i++) {
      assertTrue(phoneDirectory.check(i));
    }

    for (int i = 0; i < NUM; i++) {
      final int get = phoneDirectory.get();
      assertFalse(phoneDirectory.check(get));
    }

    for (int i = 0; i < NUM; i++) {
      phoneDirectory.release(i);
      assertTrue(phoneDirectory.check(i));
    }
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<PhoneDirectory> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final PhoneDirectory solution = solutionClass.getConstructor(Integer.TYPE).newInstance(1);
    assertTrue(solution.check(0));
    assertEquals(0, solution.get());
    assertFalse(solution.check(0));
    assertEquals(-1, solution.get());
    solution.release(0);
    assertTrue(solution.check(0));
    assertEquals(0, solution.get());
    assertEquals(-1, solution.get());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Class<PhoneDirectory> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final PhoneDirectory solution = solutionClass.getConstructor(Integer.TYPE).newInstance(3);
    solution.get();
    solution.get();
    solution.get();
    assertFalse(solution.check(2));
    assertEquals(-1, solution.get());
    solution.release(2);
    assertTrue(solution.check(2));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SetAndQueueSolution.class,
        LinkedHashSetSolution.class,
        BitSetSolution.class
    );
  }
}