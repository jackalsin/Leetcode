package _351_400._359_Logger_Rate_Limiter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/12/2017.
 */
public class LoggerTest {
  private Logger logger;

  @Before
  public void setUp() throws Exception {
    logger = new Logger();
  }

  @Test
  public void testOnlineCase() throws Exception {
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
