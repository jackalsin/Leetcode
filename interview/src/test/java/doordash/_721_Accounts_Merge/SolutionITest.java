package doordash._721_Accounts_Merge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {


    final List<List<String>> account = List.of(
        List.of("David", "David0@m.co", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co",
            "David5@m.co", "David6@m.co", "David7@m.co"),
        List.of("David", "David1@m.co", "David9@m.co", "David10@m.co", "David11@m.co", "David12@m.co", "David13@m.co"
            , "David14@m.co", "David15@m.co", "David16@m.co"),
        List.of("David", "David3@m.co", "David27@m.co", "David28@m.co", "David29@m.co", "David30@m.co", "David31@m" +
            ".co", "David32@m.co", "David33@m.co", "David34@m.co"),
        List.of("David", "David2@m.co", "David18@m.co", "David19@m.co", "David20@m.co", "David21@m.co", "David22@m" +
            ".co", "David23@m.co", "David24@m.co", "David25@m.co"),
        List.of("David", "David0@m.co", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co",
            "David5@m.co", "David6@m.co", "David7@m.co"),
        List.of("David", "David0@m.co", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co",
            "David5@m.co", "David6@m.co", "David7@m.co"),
        List.of("David", "David2@m.co", "David18@m.co", "David19@m.co", "David20@m.co", "David21@m.co", "David22@m" +
            ".co", "David23@m.co", "David24@m.co", "David25@m.co"),
        List.of("David", "David7@m.co", "David63@m.co", "David64@m.co", "David65@m.co", "David66@m.co", "David67@m" +
            ".co", "David68@m.co", "David69@m.co", "David70@m.co"),
        List.of("David", "David5@m.co", "David45@m.co", "David46@m.co", "David47@m.co", "David48@m.co", "David49@m" +
            ".co", "David50@m.co", "David51@m.co", "David52@m.co"),
        List.of("David", "David6@m.co", "David54@m.co", "David55@m.co", "David56@m.co", "David57@m.co", "David58@m" +
            ".co", "David59@m.co", "David60@m.co", "David61@m.co"),
        List.of("David", "David1@m.co", "David9@m.co", "David10@m.co", "David11@m.co", "David12@m.co", "David13@m.co"
            , "David14@m.co", "David15@m.co", "David16@m.co"),
        List.of("David", "David4@m.co", "David36@m.co", "David37@m.co", "David38@m.co", "David39@m.co", "David40@m" +
            ".co", "David41@m.co", "David42@m.co", "David43@m.co")
    );

    final Set<List<String>> expected = Set.of(
        List.of("David", "David0@m.co", "David10@m.co", "David11@m.co", "David12@m.co", "David13@m.co", "David14@m" +
                ".co", "David15@m.co", "David16@m.co", "David18@m.co", "David19@m.co", "David1@m.co", "David20@m.co",
            "David21@m.co", "David22@m.co", "David23@m.co", "David24@m.co", "David25@m.co", "David27@m.co", "David28" +
             "@m" +
                ".co", "David29@m.co", "David2@m.co", "David30@m.co", "David31@m.co", "David32@m.co", "David33@m.co",
            "David34@m.co", "David36@m.co", "David37@m.co", "David38@m.co", "David39@m.co", "David3@m.co", "David40@m" +
                ".co", "David41@m.co", "David42@m.co", "David43@m.co", "David45@m.co", "David46@m.co", "David47@m.co",
            "David48@m.co", "David49@m.co", "David4@m.co", "David50@m.co", "David51@m.co", "David52@m.co", "David54@m" +
                ".co", "David55@m.co", "David56@m.co", "David57@m.co", "David58@m.co", "David59@m.co", "David5@m.co",
            "David60@m.co", "David61@m.co", "David63@m.co", "David64@m.co", "David65@m.co", "David66@m.co", "David67" +
                "@m.co", "David68@m.co", "David69@m.co", "David6@m.co", "David70@m.co", "David7@m.co", "David9@m.co"));
    final List<List<String>> actual = solution.accountsMerge(account);
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}
