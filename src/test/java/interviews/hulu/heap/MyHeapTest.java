package interviews.hulu.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/26/2020
 */
class MyHeapTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MyHeap solution) {
    solution.add(1);
    solution.add(2);
    solution.add(3);
    solution.add(1);
    assertEquals(1, solution.remove());
    assertEquals(1, solution.remove());
    assertEquals(2, solution.remove());
    assertEquals(3, solution.remove());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(MyHeap solution) {
    solution.add(2);
    solution.add(1);
    solution.add(3);
    solution.add(1);
    assertEquals(1, solution.remove());
    assertEquals(1, solution.remove());
    assertEquals(2, solution.remove());
    assertEquals(3, solution.remove());
  }

  static Stream<MyHeap> solutionStream() {
    return Stream.of(
        new MyHeap()
    );
  }
}