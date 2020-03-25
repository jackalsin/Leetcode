package _1001_1050._1011_Capacity_To_Ship_Packages_Within_D_Days;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/24/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int weights[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, D = 5;
    assertEquals(15, solution.shipWithinDays(weights, D));
    //    1st day: 1, 2, 3, 4, 5
    //    2nd day: 6, 7
    //    3rd day: 8
    //    4th day: 9
    //    5th day: 10
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int weights[] = {3, 2, 2, 4, 1, 4}, D = 3;
    assertEquals(6, solution.shipWithinDays(weights, D));
    //    1 st day:3, 2
    //    2 nd day:2, 4
    //    3 rd day:1, 4
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int weights[] = {1, 2, 3, 1, 1}, D = 4;
    assertEquals(3, solution.shipWithinDays(weights, D));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    ClassLoader classLoader = getClass().getClassLoader();
    final File file = new File(classLoader.getResource("./_1001_1050._1011_Capacity_To_Ship_Packages_Within_D_Days" +
        "/SolutionData").getFile());
    try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
      final int[] input = Arrays.stream(getStringArray(bf.readLine()))
          .mapToInt(x -> Integer.parseInt(x.trim())).toArray();
      final int D = 8000;
      assertEquals(671, solution.shipWithinDays(input, D));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String[] getStringArray(String readLine) {
    return readLine.split(",");
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}