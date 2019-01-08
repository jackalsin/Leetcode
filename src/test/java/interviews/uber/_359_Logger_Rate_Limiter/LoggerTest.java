package interviews.uber._359_Logger_Rate_Limiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggerTest {
  private Logger solution;

  @BeforeEach
  void setUp() {
    solution = new Logger();
  }

  @Test
  void testOnlineCase() throws Exception {
    Logger logger = new Logger();

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
}