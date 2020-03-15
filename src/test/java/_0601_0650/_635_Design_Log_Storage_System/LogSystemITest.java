package _0601_0650._635_Design_Log_Storage_System;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
class LogSystemITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Solution solution = solutionClass.getConstructor().newInstance();
    solution.put(1, "2017:01:01:23:59:59");
    solution.put(2, "2017:01:01:22:59:59");
    solution.put(3, "2016:01:01:00:00:00");
    final List<Integer> expected1 = List.of(1, 2, 3),
        actual1 = solution.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
    assertEquals(new HashSet<>(expected1), new HashSet<>(actual1));
    assertEquals(expected1.size(), actual1.size());
    // return [1,2,3], because you need to return all
    // logs within 2016 and 2017.
    final List<Integer> expected2 = List.of(1, 2),
        actual2 = solution.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
    assertEquals(new HashSet<>(expected2), new HashSet<>(actual2));
    assertEquals(expected2.size(), actual2.size());
    // return [1,2], because you need to return all
    // logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        LogSystemI.class
    );
  }
}