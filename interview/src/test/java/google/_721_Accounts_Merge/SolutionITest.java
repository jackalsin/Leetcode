package google._721_Accounts_Merge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/10/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<String>> account = List.of(
        List.of("John", "johnsmith@mail.com", "john00@mail.com"),
        List.of("John", "johnnybravo@mail.com"),
        List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        List.of("Mary", "mary@mail.com")
    );

    final Set<List<String>> expected = Set.of(
        List.of("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
        List.of("John", "johnnybravo@mail.com"),
        List.of("Mary", "mary@mail.com"));
    final List<List<String>> actual = solution.accountsMerge(account);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<String>> account = List.of(
        List.of("David", "David0@m.co", "David1@m.co"),
        List.of("David", "David3@m.co", "David4@m.co"),
        List.of("David", "David4@m.co", "David5@m.co"),
        List.of("David", "David1@m.co", "David2@m.co"),
        List.of("David", "David2@m.co", "David3@m.co")
    );

    final Set<List<String>> expected = Set.of(
        List.of("David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co")
    );
    final List<List<String>> actual = solution.accountsMerge(account);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<String>> account = List.of(
        List.of("Ethan", "Ethan1@m.co", "Ethan2@m.co", "Ethan0@m.co"),
        List.of("David", "David1@m.co", "David2@m.co", "David0@m.co"),
        List.of("Lily", "Lily0@m.co", "Lily0@m.co", "Lily4@m.co"),
        List.of("Gabe", "Gabe1@m.co", "Gabe4@m.co", "Gabe0@m.co"),
        List.of("Ethan", "Ethan2@m.co", "Ethan1@m.co", "Ethan0@m.co")
    );

    final Set<List<String>> expected = Set.of(
        List.of("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe4@m.co"),
        List.of("Ethan", "Ethan0@m.co", "Ethan1@m.co", "Ethan2@m.co"),
        List.of("David", "David0@m.co", "David1@m.co", "David2@m.co"),
        List.of("Lily", "Lily0@m.co", "Lily4@m.co")
    );
    final List<List<String>> actual = solution.accountsMerge(account);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final List<List<String>> account = List.of(
        //                1             2
        List.of("David", "David0@m.co", "David1@m.co"),
        //                3             4
        List.of("David", "David3@m.co", "David4@m.co"),
        //                4             5
        List.of("David", "David4@m.co", "David5@m.co"),
        //                6             3
        List.of("David", "David2@m.co", "David3@m.co"),
        //                2             6
        List.of("David", "David1@m.co", "David2@m.co")
    );

    final Set<List<String>> expected = Set.of(
        List.of("David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co")
    );
    final List<List<String>> actual = solution.accountsMerge(account);
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new UnionFindSolution()
    );
  }
}