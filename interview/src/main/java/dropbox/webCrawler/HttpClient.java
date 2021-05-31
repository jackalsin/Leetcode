package dropbox.webCrawler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/28/2021
 */
public final class HttpClient {
  private final Map<String, List<String>> all;

  public HttpClient(final Map<String, List<String>> urls) {
    all = Collections.unmodifiableMap(urls);
  }

  public List<String> getChildUrls(final String url) {
    return all.getOrDefault(url, Collections.emptyList());
  }
}
