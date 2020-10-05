package _1201_1250._1242_Web_Crawler_Multithreaded;

import definition._1242_Web_Crawler_Multithreaded.HtmlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
public class ParallelSteamSolution implements Solution {
  private static final String PREFIX = "https://";
  private static final Object DUMMY = new Object();
  private final ConcurrentHashMap<String, Object> scheduled = new ConcurrentHashMap<>();

  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    final String hostname = getHostname(startUrl);
    scheduled.put(startUrl, DUMMY);
    crawl(startUrl, hostname, htmlParser);
    return new ArrayList<>(scheduled.keySet());
  }

  private void crawl(final String startUrl, final String hostname, final HtmlParser htmlParser) {
    htmlParser.getUrls(startUrl).parallelStream().
        filter(url -> url.startsWith(hostname)).
        filter(url -> scheduled.put(url, DUMMY) == null).
        forEach(url -> crawl(url, hostname, htmlParser));
  }

  private static String getHostname(final String startUrl) {
    final int index = startUrl.indexOf('/', PREFIX.length());
    return index == -1 ? startUrl : startUrl.substring(0, index);
  }
}
