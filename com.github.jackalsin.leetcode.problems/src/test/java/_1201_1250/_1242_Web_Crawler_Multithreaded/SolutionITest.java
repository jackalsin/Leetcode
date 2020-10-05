package _1201_1250._1242_Web_Crawler_Multithreaded;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._1242_Web_Crawler_Multithreaded.HtmlParserI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] urls = {"http://news.yahoo.com",
        "http://news.yahoo.com/news",
        "http://news.yahoo.com/news/topics/",
        "http://news.google.com",
        "http://news.yahoo.com/us"};
    final int[][] edges = {
        {2, 0}, {2, 1}, {3, 2}, {3, 1}, {0, 4}
    };
    final HtmlParserI htmlParser = getHtmlParser(urls, edges);
    final String startUrl = "http://news.yahoo.com/news/topics/";
    final Set<String> expected = Set.of(
        "http://news.yahoo.com/news/topics/",
        "http://news.yahoo.com/news",
        "http://news.yahoo.com/us",
        "http://news.yahoo.com"
    );
    final List<String> actual = solution.crawl(startUrl, htmlParser);
    assertEquals(expected, new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  private static HtmlParserI getHtmlParser(final String[] urls, final int[][] edges) {
    final HtmlParserI htmlParser = new HtmlParserI();
    htmlParser.addUrls(urls, edges);
    return htmlParser;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ExecutorServiceSolution()
        , new ParallelSteamSolution()
    );
  }
}