package _1151_1200._1166_Design_File_System;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<FileSystem> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    FileSystem solution = solutionClass.getConstructor().newInstance();
    assertTrue(solution.createPath("/a", 1));
    assertEquals(1, solution.get("/a"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<FileSystem> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    FileSystem solution = solutionClass.getConstructor().newInstance();
    assertTrue(solution.createPath("/leet", 1));
    assertTrue(solution.createPath("/leet/code", 2));
    assertEquals(2, solution.get("/leet/code"));
    assertFalse(solution.createPath("/c/d", 1));
    assertEquals(-1, solution.get("/c"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Class<FileSystem> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    FileSystem solution = solutionClass.getConstructor().newInstance();
    assertTrue(solution.createPath("/leet", 1));
    assertTrue(solution.createPath("/leet/code", 2));
    assertEquals(2, solution.get("/leet/code"));
    assertFalse(solution.createPath("/leet/code", 3));
    assertEquals(2, solution.get("/leet/code"));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        TreeSolution.class,
        OneMapSolution.class
    );
  }
}