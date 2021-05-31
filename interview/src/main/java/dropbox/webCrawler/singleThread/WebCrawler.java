package dropbox.webCrawler.singleThread;

import dropbox.webCrawler.Crawler;
import dropbox.webCrawler.HttpClient;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/28/2021
 */
public final class WebCrawler implements Crawler {
  private final HttpClient client;

  public WebCrawler(final HttpClient client) {
    this.client = client;
  }

  @Override
  public List<String> crawl(final String url) {
    if (url == null) throw new NullPointerException();
    if (url.isEmpty()) throw new IllegalArgumentException("url cannot be empty but " + url);
//    return crawlDfs(url);
    return crawlBfs(url);
  }

  private List<String> crawlDfs(final String url) {
    final Set<String> result = new HashSet<>();
    crawlDfs(result, url);
    return new ArrayList<>(result);
  }

  private void crawlDfs(final Set<String> result, final String url) {
    final List<String> children = client.getChildUrls(url);
    if (children == null || children.isEmpty()) return;
    for (final String c : children) {
      if (!result.add(c)) continue;
      crawlDfs(result, c);
    }
  }

  private List<String> crawlBfs(final String url) {
    final Queue<String> q = new ArrayDeque<>() {{
      add(url);
    }};
    final Set<String> visited = new HashSet<>() {{
      add(url);
    }};
    while (!q.isEmpty()) {
      final String toRemove = q.remove();
      final List<String> children = client.getChildUrls(toRemove);
      for (final String c : children) {
        if (visited.add(c)) {
          q.add(c);
        }
      }
    }
    return new ArrayList<>(visited);
  }
}