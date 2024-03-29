package doordash._359_Logger_Rate_Limiter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution logger) {
// logging string "foo" at timestamp 1
    assertTrue(logger.shouldPrintMessage(1, "foo"));

// logging string "bar" at timestamp 2
    assertTrue(logger.shouldPrintMessage(2, "bar"));

// logging string "foo" at timestamp 3
    assertFalse(logger.shouldPrintMessage(3, "foo"));

// logging string "bar" at timestamp 8
    assertFalse(logger.shouldPrintMessage(8, "bar"));

// logging string "foo" at timestamp 10
    assertFalse(logger.shouldPrintMessage(10, "foo"));

// logging string "foo" at timestamp 11
    assertTrue(logger.shouldPrintMessage(11, "foo"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
