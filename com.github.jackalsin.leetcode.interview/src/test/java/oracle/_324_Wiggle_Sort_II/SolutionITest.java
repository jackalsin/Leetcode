package oracle._324_Wiggle_Sort_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
class SolutionITest {

  @Test
  void test1() {
    Assertions.assertEquals(0, SolutionI.getIndex(1, 0));
  }

  @Test
  void test2() {
    assertEquals(1, SolutionI.getIndex(2, 0));
    assertEquals(0, SolutionI.getIndex(2, 1));
  }

  @Test
  void test7() {
    assertEquals(1, SolutionI.getIndex(7, 0));
    assertEquals(3, SolutionI.getIndex(7, 1));
    assertEquals(5, SolutionI.getIndex(7, 2));
    assertEquals(0, SolutionI.getIndex(7, 3));
    assertEquals(2, SolutionI.getIndex(7, 4));
    assertEquals(4, SolutionI.getIndex(7, 5));
    assertEquals(6, SolutionI.getIndex(7, 6));
  }

  @Test
  void test6() {
    assertEquals(1, SolutionI.getIndex(6, 0));
    assertEquals(3, SolutionI.getIndex(6, 1));
    assertEquals(5, SolutionI.getIndex(6, 2));
    assertEquals(0, SolutionI.getIndex(6, 3));
    assertEquals(2, SolutionI.getIndex(6, 4));
    assertEquals(4, SolutionI.getIndex(6, 5));
  }

}