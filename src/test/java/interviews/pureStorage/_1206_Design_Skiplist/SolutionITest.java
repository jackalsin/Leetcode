package interviews.pureStorage._1206_Design_Skiplist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Skiplist solution) {
    solution.add(1);
    solution.add(2);
    solution.add(3);
    assertFalse(solution.search(0));   // return false.
    solution.add(4);
    assertTrue(solution.search(1));   // return true.
    assertFalse(solution.erase(0));    // return false, 0 is not in skiplist.
    assertTrue(solution.erase(1));    // return true.
    assertFalse(solution.search(1));   // return false, 1 has already been erased.
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Skiplist solution) {
//  "add","add","add","add","search","erase","search","search","search"]
//  [0],  [5],   [2],   [1],  [0],    [5],      [2],      [3],    [2]
    solution.add(0);
    solution.add(5);
    solution.add(2);
    solution.add(1);
    assertTrue(solution.search(0));
    assertTrue(solution.erase(5));
    assertTrue(solution.search(2));
    assertFalse(solution.search(3));
    assertTrue(solution.search(2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Skiplist solution) {
// ["add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
// [1],     [2],  [3],    [0],      [4],    [1],      [0],    [1],      [1]
// [null,   null, null,   false,    null,  true,    false,    true,     false]
    solution.add(1);
    solution.add(2);
    solution.add(3);
    assertFalse(solution.search(0));
    solution.add(4);
    assertTrue(solution.search(1));
    assertFalse(solution.erase(0));
    assertTrue(solution.erase(1));
    assertFalse(solution.search(1));
  }

  static Stream<Skiplist> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}