package dropbox.webCrawler;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/28/2021
 */
public interface Crawler {

  List<String> crawl(final String urls);
}
