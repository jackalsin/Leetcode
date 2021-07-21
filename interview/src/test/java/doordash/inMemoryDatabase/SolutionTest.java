package doordash.inMemoryDatabase;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    solution.set("a", 1);
    assertEquals(1, solution.get("a")); // return 1
    solution.unset("a");
    assertEquals(-1, solution.get("a")); // return -1
    solution.set("a", 2);
    solution.begin();
    assertEquals(2, solution.get("a")); // return 2
    solution.set("a", 3);
    assertEquals(3, solution.get("a"));// return 3;
    assertTrue(solution.rollback());// return true;
    assertEquals(2, solution.get("a"));// return 2
    assertFalse(solution.rollback());// return false;
    solution.begin();
    solution.set("a", 5);
    solution.begin();
    solution.set("a", 7);
    assertTrue(solution.commit());// return true
    assertEquals(7, solution.get("a"));// return 7
    assertFalse(solution.rollback()); // return false
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
