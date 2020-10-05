package utils._1242_Web_Crawler_Multithreaded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
public final class HtmlParserI implements HtmlParser {
  private final Map<String, List<String>> urls = new HashMap<>();

  public void addUrls(final String[] urls, final int[][] edges) {
    for (final int[] e : edges) {
      final int from = e[0], to = e[1];
      this.urls.computeIfAbsent(urls[from], k -> new ArrayList<>()).add(urls[to]);
    }
  }

  @Override
  public List<String> getUrls(String url) {
    return urls.getOrDefault(url, new ArrayList<>());
  }
}
