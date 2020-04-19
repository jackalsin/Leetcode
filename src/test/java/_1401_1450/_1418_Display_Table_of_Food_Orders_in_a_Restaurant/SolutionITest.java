package _1401_1450._1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<List<String>> orders = List.of(
        List.of("David", "3", "Ceviche"),
        List.of("Corina", "10", "Beef Burrito"),
        List.of("David", "3", "Fried Chicken"),
        List.of("Carla", "5", "Water"),
        List.of("Carla", "5", "Ceviche"),
        List.of("Rous", "3", "Ceviche")), expected = List.of(
        List.of("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
        List.of("3", "0", "2", "1", "0"),
        List.of("5", "0", "1", "0", "1"),
        List.of("10", "1", "0", "0", "0")
    ), actual = solution.displayTable(orders);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}