package _0501_0550._524_Longest_Word_in_Dictionary_through_Deleting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new UnSortedSolution(),
        new SortSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final String s = "abpcplea";
    final List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
    assertEquals("apple", solution.findLongestWord(s, d));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final String s = "abpcplea";
    final List<String> d = Arrays.asList("a", "b", "c");
    assertEquals("a", solution.findLongestWord(s, d));
  }

}