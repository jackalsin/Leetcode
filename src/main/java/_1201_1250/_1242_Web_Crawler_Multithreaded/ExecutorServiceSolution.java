package _1201_1250._1242_Web_Crawler_Multithreaded;

import utils._1242_Web_Crawler_Multithreaded.HtmlParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author jacka
 * @version 1.0 on 1/4/2020
 */
public final class ExecutorServiceSolution implements Solution {
  private static final String PREFIX = "https://";
  private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
  private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  private final HashSet<String> scheduled = new HashSet<>();

  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    final String hostname = getHostname(startUrl);
    scheduled.add(startUrl);
    final Future<?> future = EXECUTOR_SERVICE.submit(new CrawlTask(startUrl, hostname, htmlParser));
    try {
      future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return new ArrayList<>(scheduled);
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
      final List<Future<?>> futures = new ArrayList<>();
      for (String c : children) {
//        System.out.print("checking url = " + c);
        if (!c.startsWith(hostname)) {
//          System.out.println(" skip");
          continue;
        }
        synchronized (scheduled) {
          if (scheduled.add(c)) {
//            System.out.println(" adding to q");
            futures.add(EXECUTOR_SERVICE.submit(new CrawlTask(c, hostname, htmlParser)));
          }
        }
      } // end of for loop
      for (Future<?> f : futures) {
        try {
          f.get();
//          System.out.println("waiting for finishing");
        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
