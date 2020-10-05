package utils._1242_Web_Crawler_Multithreaded;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/3/2020
 */
public interface HtmlParser {
  List<String> getUrls(String url);
}
