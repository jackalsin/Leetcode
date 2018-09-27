package interviews.linkedin._065_Valid_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class SolutionIIITest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionIII();
  }

  @Test
  public void test0() throws Exception {
    assertTrue(solution.isNumber("0"));
  }

  @Test
  public void test0_1() throws Exception {
    assertTrue(solution.isNumber("0.1"));
    assertTrue(solution.isNumber(" 0.1 "));
  }

  @Test
  public void testAbc() throws Exception {
    assertFalse(solution.isNumber("abc"));
  }

  @Test
  public void test1a() throws Exception {
    assertFalse(solution.isNumber("1a"));
  }

  @Test
  public void test03() throws Exception {
    assertTrue(solution.isNumber(".3"));
  }

  @Test
  public void test03E81() throws Exception {
    assertTrue(solution.isNumber(".3e81"));
  }

  @Test
  public void test3Point0() throws Exception {
    assertTrue(solution.isNumber("3."));
  }

  @Test
  public void test2e10() throws Exception {
    assertTrue(solution.isNumber("2e10"));
  }

  @Test
  public void test2E10() throws Exception {
    assertTrue(solution.isNumber("2E10"));
  }

  @Test
  public void test2E3Point5() throws Exception {
    assertFalse(solution.isNumber("2E3.5"));
  }

  @Test
  public void test2ENegative3Point5() throws Exception {
    assertFalse(solution.isNumber("2E3.5"));
  }

  @Test
  public void testEmpty() throws Exception {
    assertFalse(solution.isNumber(""));
  }
}
