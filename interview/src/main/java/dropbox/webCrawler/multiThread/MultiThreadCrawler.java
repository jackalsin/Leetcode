package dropbox.webCrawler.multiThread;

import dropbox.webCrawler.Crawler;
import dropbox.webCrawler.HttpClient;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author jacka
 * @version 1.0 on 5/29/2021
 */

public final class MultiThreadCrawler implements Crawler {
  private static final int MAX_THREAD_COUNT = Runtime.getRuntime().availableProcessors();
  private final Set<String> submittedTasks = Collections.newSetFromMap(new ConcurrentHashMap<>());
  private final Queue<Future<List<String>>> pendingTasks = new ArrayDeque<>();
  private final ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
  private final HttpClient client;

  public MultiThreadCrawler(final HttpClient client) {
    this.client = client;
  }

  @Override
  public List<String> crawl(String url) {
    submitUrl(url);
    try {
      while (!pendingTasks.isEmpty()) {
        final Iterator<Future<List<String>>> itr = pendingTasks.iterator();
        while (itr.hasNext()) {
          final Future<List<String>> next = itr.next();
          if (next.isDone()) {
            itr.remove();
            try {
              final List<String> children = next.get();
              for (final String c : children) {
                submitUrl(c);
              }
            } catch (InterruptedException e) {
              e.printStackTrace();
            } catch (ExecutionException e) {
              e.printStackTrace();
            }
          } // end of isDone
        }
      }
      return new ArrayList<>(submittedTasks);
    } finally {
      shutdownAndAwaitTermination();
    }
  }

  private void submitUrl(final String url) {
    if (!submittedTasks.add(url)) return;
    final CrawlTask crawlTask = new CrawlTask(url);
    final Future<List<String>> children = executorService.submit(crawlTask);
    pendingTasks.add(children);
  }

  private void shutdownAndAwaitTermination() {
    executorService.shutdown(); // Disable new tasks from being submitted
    try {
      // Wait a while for existing tasks to terminate
      if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        executorService.shutdownNow(); // Cancel currently executing tasks
        // Wait a while for tasks to respond to being cancelled
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
          System.err.println("Pool did not terminate");
      }
    } catch (InterruptedException ie) {
      // (Re-)Cancel if current thread also interrupted
      executorService.shutdownNow();
      // Preserve interrupt status
      Thread.currentThread().interrupt();
    }
  }

  private class CrawlTask implements Callable<List<String>> {
    private final String url;

    private CrawlTask(final String url) {
      this.url = url;
    }

    @Override
    public List<String> call() throws Exception {
      return client.getChildUrls(url);
    }
  }
}
