package _0351_0400._379_Design_Phone_Directory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

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
      System.out.println(get);
      assertFalse(phoneDirectory.check(get));
    }

    for (int i = 0; i < NUM; i++) {
      phoneDirectory.release(i);
      System.out.println("Release " + i);
      assertTrue(phoneDirectory.check(i));
    }
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        PhoneDirectory.class
    );
  }
}