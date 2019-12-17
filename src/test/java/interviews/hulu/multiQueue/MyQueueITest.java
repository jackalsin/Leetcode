package interviews.hulu.multiQueue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/16/2019
 */
class MyQueueITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(MultiQueue solution) {
    final int[] arr1 = {0, 1, 2, 3},
        arr2 = {4, 5, 6, 7},
        arr3 = {8, 9, 10, 11},
        arr4 = {12, 13, 14, 15};
    solution.add(arr1);
    solution.add(arr2);
    final List<Integer> expected1 = List.of(0, 1, 2, 3);
    assertEquals(expected1, solution.read(4));
    solution.add(arr3);
    solution.add(arr4);
    final List<Integer> expected2 = List.of(4, 5);
    assertEquals(expected2, solution.read(2));
    solution.remove(arr3);
    final List<Integer> expected3 = List.of(6, 7, 12, 13);
    assertEquals(expected3, solution.read(4));
  }

  static Stream<MultiQueue> solutionProvider() {
    return Stream.of(
        new MyQueueI()
    );
  }
}