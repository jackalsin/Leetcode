package dropbox.webCrawler;

import dropbox.webCrawler.multiThread.MultiThreadCrawler;
import dropbox.webCrawler.singleThread.WebCrawler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/29/2021
 */
class CrawlerTest {
  private final String GOOGLE = "Https://google.com",
      MICROSOFT = "https://microsoft.com",
      APPLE = "https://apple.com",
      AMAZON = "https://amazon.com";

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<Crawler> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final Map<String, List<String>> urls = Map.of(
        GOOGLE, List.of(MICROSOFT, APPLE),
        MICROSOFT, List.of(APPLE),
        APPLE, List.of(AMAZON),
        AMAZON, List.of(AMAZON)
    );
    final HttpClient client = new HttpClient(urls);
    final Crawler crawler = solutionClass.getConstructor(HttpClient.class).newInstance(client);
    final List<String> expected = List.of(GOOGLE, APPLE, MICROSOFT, AMAZON),
        actual = crawler.crawl(GOOGLE);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals((expected).size(), (actual).size());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        WebCrawler.class,
        MultiThreadCrawler.class
    );
  }


}