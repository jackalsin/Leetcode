package _1201_1250._1242_Web_Crawler_Multithreaded;

import definition._1242_Web_Crawler_Multithreaded.HtmlParser;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/3/2020
 */
public interface Solution {
   List<String> crawl(String startUrl, HtmlParser htmlParser);
}
