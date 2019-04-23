package interviews.airbnb.guessNumber.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static interviews.airbnb.guessNumber.common.Settings.BREAK;
import static interviews.airbnb.guessNumber.common.Settings.PORT;


public final class Server {
  private final String num;
  private static final int THREADS = Runtime.getRuntime().availableProcessors(), N = 4;
  private final ExecutorService threadPool = Executors.newFixedThreadPool(THREADS);
  private ServerSocket serverSocket = new ServerSocket(PORT);

  public Server(final String num) throws IOException {
    this.num = num;
  }

  public void run() throws IOException {
    while (true) {
      Socket clientSocket = serverSocket.accept();
      threadPool.execute(() -> worker(clientSocket));
    }
  }

  public void worker(final Socket clientSocket) {
    try (
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
    ) {
      while (true) {
        System.out.println("Waiting for the input");
        String inputLine = in.readLine();
        if (BREAK.equals(inputLine)) {
          System.out.println("ENDING Server Thread");
          break;
        }
        final String resp = get(inputLine);
        out.println(resp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void shutdown() throws IOException {
    threadPool.shutdown(); // Disable new tasks from being submitted
    try {
      // Wait a while for existing tasks to terminate
      if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
        threadPool.shutdownNow(); // Cancel currently executing tasks
        // Wait a while for tasks to respond to being cancelled
        if (!threadPool.awaitTermination(60, TimeUnit.SECONDS))
          System.err.println("Pool did not terminate");
      }
    } catch (InterruptedException ie) {
      // (Re-)Cancel if current thread also interrupted
      threadPool.shutdownNow();
      // Preserve interrupt status
      Thread.currentThread().interrupt();
    }
    serverSocket.close();
  }

  /**
   * @param guess the 4 digits guess
   * @return exact + a space + mis position
   */
  public String get(final String guess) {
    System.out.println(guess);
    if (guess == null || guess.length() != N) {
      throw new IllegalArgumentException(guess);
    }
    int exact = 0, misPos = 0;
    final int[] count = new int[10];
    for (int i = 0; i < guess.length(); i++) {
      final int n = num.charAt(i) - '0', g = guess.charAt(i) - '0';
      if (n == g) {
        exact++;
      } else {
        if (count[n] < 0) misPos++;
        if (count[g] > 0) misPos++;
        count[g]--;
        count[n]++;
      }
    }
    return exact + " " + misPos;
  }

  public static void main(final String[] args) throws IOException {
    final Server s = new Server("1111");
    s.run();
  }

}
