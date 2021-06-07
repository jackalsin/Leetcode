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

/**
 * @author jacka
 * @version 1.0 on 6/7/2021
 */
public final class MultiThreadSolutionI implements Crawler {
  private final HttpClient client;
  private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
  private final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
  private final Queue<Future<List<String>>> pendingTasks = new ArrayDeque<>();
  private final Set<String> visited = Collections.newSetFromMap(new ConcurrentHashMap<>());

  public MultiThreadSolutionI(final HttpClient client) {
    this.client = client;
  }

  @Override
  public List<String> crawl(String url) {
    submit(url);
    try {
      while (!pendingTasks.isEmpty()) {
        final Iterator<Future<List<String>>> itr = pendingTasks.iterator();
        while (itr.hasNext()) {
          final Future<List<String>> toRemove = itr.next();
          if (toRemove.isDone()) {
            itr.remove();
            final List<String> children = toRemove.get();
            for (final String c : children) {
              submit(c);
            }
          }
        }
      }
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // shutdown

    }

    return new ArrayList<>(visited);
  }

  private void submit(final String url) {
    if (visited.add(url)) {
      final CrawlTask task = new CrawlTask(client, url);
      pendingTasks.add(executor.submit(task));
    }
  }

  private static final class CrawlTask implements Callable<List<String>> {
    private final HttpClient client;
    private final String url;

    private CrawlTask(final HttpClient client, final String url) {
      this.client = client;
      this.url = url;
    }

    @Override
    public List<String> call() throws Exception {
      return client.getChildUrls(url);
    }
  }
}
