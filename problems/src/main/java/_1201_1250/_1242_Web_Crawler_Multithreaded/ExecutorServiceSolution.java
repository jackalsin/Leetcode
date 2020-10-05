package _1201_1250._1242_Web_Crawler_Multithreaded;

import definition._1242_Web_Crawler_Multithreaded.HtmlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
public final class ExecutorServiceSolution implements Solution {
  private static final String PREFIX = "https://";
  private static final Object DUMMY = new Object();
  private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
  private static final ExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
  private final ConcurrentHashMap<String, Object> scheduled = new ConcurrentHashMap<>();
  private final BlockingQueue<Future<?>> futures = new LinkedBlockingDeque<>();

  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    final String hostname = getHostname(startUrl);
    scheduled.put(startUrl, DUMMY);
    futures.add(EXECUTOR_SERVICE.submit(new CrawlTask(startUrl, hostname, htmlParser)));
    while (!futures.isEmpty()) {
      try {
        futures.remove().get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    return new ArrayList<>(scheduled.keySet());
  }

  private static String getHostname(final String startUrl) {
    final int index = startUrl.indexOf('/', PREFIX.length());
    return index == -1 ? startUrl : startUrl.substring(0, index);
  }

  private final class CrawlTask implements Runnable {
    private final HtmlParser htmlParser;
    private final String hostname;
    private final String startUrl;

    private CrawlTask(final String startUrl, final String hostname, final HtmlParser htmlParser) {
      this.startUrl = startUrl;
      this.hostname = hostname;
      this.htmlParser = htmlParser;
    }

    @Override
    public void run() {
      final List<String> children = htmlParser.getUrls(startUrl);
      children.parallelStream().forEach(
          c -> {
            if (!c.startsWith(hostname)) {
              return;
            }
            if (scheduled.put(c, DUMMY) == null) {
              futures.add(EXECUTOR_SERVICE.submit(new CrawlTask(c, hostname, htmlParser)));
            }
          }
      );
    }
  }
}
