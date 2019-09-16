package _1151_1200._1178_Number_of_Valid_Words_for_Each_Puzzle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
        puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
    final List<Integer> expected = List.of(1, 1, 3, 2, 4, 0),
        actual = solution.findNumOfValidWords(words, puzzles);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    ClassLoader classLoader = getClass().getClassLoader();
    final File file = new File(classLoader.getResource("./_1151_1200/_1178_Number_of_Valid_Words_for_Each_Puzzle" +
        "/TLESolutionData").getFile());
    String[] words = null, puzzles = null;
    List<Integer> expected = List.of();
    try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
      words = getStringArray(bf.readLine());
      puzzles = getStringArray(bf.readLine());
      expected = Arrays.stream(getStringArray(bf.readLine()))
          .mapToInt(x -> Integer.parseInt(x.trim())).boxed().collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    final List<Integer> actual = solution.findNumOfValidWords(words, puzzles);
    assertEquals(expected, actual);
  }

  private static String[] getStringArray(String readLine) {
    return readLine.split(",");
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SampleSolution(),
        new SampleSolutionII()
    );
  }
}