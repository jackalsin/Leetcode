package airbnb.parseCsv.stdinOut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String input = "Weronika,Zaborska,njkfdsv@dsgfk.sn,\"running, sc-fi\",new,Krakow,25";
    final List<String> expected = List.of(
        "Weronika", "Zaborska", "njkfdsv@dsgfk.sn", "running, sc-fi", "new", "Krakow", "25"
    );
    final List<String> actual = solution.parse(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final String input = "Ryuichi,Akiyama,jkg@ljnsfd.fjn,music,guide,Tokyo,65";
    final List<String> expected = List.of(
        "Ryuichi", "Akiyama", "jkg@ljnsfd.fjn", "music", "guide", "Tokyo", "65"
    );
    final List<String> actual = solution.parse(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final String input = "Elena,Martinez,emrt@lsofnbr.rt,\"cooking, traveling\",superhost,Valencia,42";
    final List<String> expected = List.of(
        "Elena", "Martinez", "emrt@lsofnbr.rt", "cooking, traveling", "superhost", "Valencia", "42"
    );
    final List<String> actual = solution.parse(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase4() {
    final String input = "\"John \"\"Mo\"\"\",Smith,sfn@flkaei.km,biking and hiking,,\"Seattle, WA\",23";
    final List<String> expected = List.of(
        "John \"Mo\"", "Smith", "sfn@flkaei.km", "biking and hiking", "", "Seattle, WA", "23"
    );
    final List<String> actual = solution.parse(input);
    assertEquals(expected, actual);
  }

}