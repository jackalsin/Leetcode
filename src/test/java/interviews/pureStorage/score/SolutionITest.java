package interviews.pureStorage.score;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/9/2019
 */
class SolutionITest {

  @Test
  void testGetScore1() {
    assertEquals(10, SolutionI.getScore1("7571"));
    assertEquals(18, SolutionI.getScore2("12222".toCharArray()));
    assertEquals(15, SolutionI.getScore3("9765320".toCharArray()));
    assertEquals(4, SolutionI.getScore4(3));
    assertEquals(0, SolutionI.getScore4(1));
    assertEquals(3, SolutionI.getScore5(156));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }

}