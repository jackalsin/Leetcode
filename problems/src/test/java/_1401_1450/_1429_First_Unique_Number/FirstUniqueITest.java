package _1401_1450._1429_First_Unique_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/28/2020
 */
class FirstUniqueITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<FirstUnique> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {2, 3, 5};
    FirstUnique firstUnique = cacheClass.getConstructor(int[].class).newInstance(nums);
    assertEquals(2, firstUnique.showFirstUnique()); // return 2
    firstUnique.add(5);            // the queue is now [2,3,5,5]
    assertEquals(2, firstUnique.showFirstUnique()); // return 2
    firstUnique.add(2);            // the queue is now [2,3,5,5,2]
    assertEquals(3, firstUnique.showFirstUnique()); // return 3
    firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
    assertEquals(-1, firstUnique.showFirstUnique()); // return -1
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<FirstUnique> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {7, 7, 7, 7, 7, 7};
    FirstUnique firstUnique = cacheClass.getConstructor(int[].class).newInstance(nums);
    assertEquals(-1, firstUnique.showFirstUnique()); // return -1
    firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
    firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
    firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
    firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
    firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
    assertEquals(17, firstUnique.showFirstUnique()); // return 17
    firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17,17]
    firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17,17,17]
    assertEquals(-1, firstUnique.showFirstUnique());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Class<FirstUnique> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {809};
    FirstUnique firstUnique = cacheClass.getConstructor(int[].class).newInstance(nums);
    assertEquals(809, firstUnique.showFirstUnique()); // return 809
    firstUnique.add(809);          // the queue is now [809,809]
    assertEquals(-1, firstUnique.showFirstUnique()); // return -1
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        FirstUniqueI.class
    );
  }

}